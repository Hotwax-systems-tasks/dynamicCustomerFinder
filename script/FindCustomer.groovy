import org.moqui.context.ExecutionContext;
import org.moqui.entity.EntityCondition;
import org.moqui.entity.EntityFind;
import org.moqui.entity.EntityList;
import org.moqui.entity.EntityValue

ExecutionContext ec = context.ec;

EntityFind ef = ec.entity.find("package.view.EntitiesView").distinct(true);

if(firstName) {
    
   ef.condition("firstName", EntityCondition.LIKE, '%' + firstName + "%").ignoreCase();
}
if(lastName) {
    ef.condition("lastName", EntityCondition.LIKE, '%' + lastName + "%").ignoreCase();
}
if(email) {
    ef.condition("email", EntityCondition.LIKE, '%' + email + "%").ignoreCase();
}

if(phone) {
    ef.condition("phone", EntityCondition.LIKE, '%' + phone + "%").ignoreCase();
}

if(address) {
    ef.condition("address", EntityCondition.LIKE, '%' + address + "%").ignoreCase();
}

if(city) {
    ef.condition("city", EntityCondition.LIKE, '%' + city + "%").ignoreCase();
}

if(state) {
    ef.condition("state", EntityCondition.LIKE, '%' + state + "%").ignoreCase();
}


partyIdList = []

ef.orderBy("lastName", "firstName");

EntityList entityList = ef.list();
for(EntityValue ev in entityList) {
    partyIdList.add(ev.partyId);
}
