import org.moqui.context.ExecutionContext
import org.moqui.entity.EntityCondition
import org.moqui.entity.EntityFind
import org.moqui.entity.EntityList
import org.moqui.entity.EntityValue
import java.sql.Timestamp


ExecutionContext ec = context.ec
def currentDate = new Timestamp(System.currentTimeMillis()) 

EntityFind ef = ec.entity.find('party.package.FindCustomerView')
ef.selectFields()
if (emailAddress) {
    ef.condition("infoString", emailAddress)
}

EntityValue el = ef.one()

if (el != null) {
    def existingPartyContactMech = el.get('PartyContactMech')
    if (existingPartyContactMech != null) {
        existingPartyContactMech.set('thruDate', currentDate)
        existingPartyContactMech.update()
    }

    def contactMechId = el.get('contactMechId')
    def partyId = el.get('partyId')
    def newPartyContactMech = ec.entity.makeValue('PartyContactMech')
    newPartyContactMech.set('partyId', partyId)
    newPartyContactMech.set('contactMechId', contactMechId)
    newPartyContactMech.set('contactMechPurposeEnumId', 'EmailPrimary')
    newPartyContactMech.set('fromDate', currentDate)
    newPartyContactMech.create()

    def postalAddressEntity = ec.entity.makeValue('PostalAddress')
    postalAddressEntity.set('contactMechId', contactMechId)
    postalAddressEntity.set('address1', address1)
    postalAddressEntity.set('address2', address2)
    postalAddressEntity.set('city', city)
    postalAddressEntity.set('postalCode', postalCode)
    postalAddressEntity.set('state', state)
    postalAddressEntity.create()

    def telecomNumberEntity = ec.entity.makeValue('TelecomNumber')
    telecomNumberEntity.set('contactMechId', contactMechId)
    telecomNumberEntity.set('contactNumber', contactNumber)
    telecomNumberEntity.create()

} else {
    throw new RuntimeException("Customer not found with email: ${emailAddress}")
}

