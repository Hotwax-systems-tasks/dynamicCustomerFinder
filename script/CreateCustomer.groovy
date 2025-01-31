import org.moqui.context.ExecutionContext
import org.moqui.entity.EntityCondition
import org.moqui.entity.EntityFind
import org.moqui.entity.EntityList
import org.moqui.entity.EntityValue

import java.sql.Timestamp

def currentDate = new Timestamp(System.currentTimeMillis())

EntityFind ef = ec.entity.find('Moqui.Party.FindCustomerView')
ef.selectFields()

ef.condition("infoString", emailAddress)
EntityValue el=ef.one()

if (el == null) {
    def findEntity = ec.entity.makeValue('Party')
    findEntity.setSequencedIdPrimary()
    findEntity.set('partyTypeEnumId', 'Person')
    findEntity.create()

    def partyId = findEntity.get('partyId')

    def partyrole = ec.entity.makeValue('PartyRole')
    partyrole.set('partyId',partyId)
    partyrole.set('roleTypeEnumId','Customer')
    partyrole.create()



    
    def person = ec.entity.makeValue('Person')
    person.set('partyId', pid)
    person.set('firstName', firstName)
    person.set('lastName', lastName)
    person.create()

    def contactMech = ec.entity.makeValue('ContactMech')
    contactMech.setSequencedIdPrimary()
    contactMech.set('infoString', emailAddress)
    contactMech.create()

    def contactMechId = contactMechEntity.get('contactMechId')

    def partyContactMech = ec.entity.makeValue('PartyContactMech')
    partyContactMech.set('partyId', pid)
    partyContactMech.set('contactMechId', contactMechId)
    partyContactMech.set('contactMechPurposeEnumId', 'EmailPrimary')
    partyContactMech.set('fromDate', currentDate)
    partyContactMech.create()
}