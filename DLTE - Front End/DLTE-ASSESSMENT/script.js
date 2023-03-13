function perform(){

let pname=document.forms['pays'].name.value;
let pacc=document.forms['pays'].accno.value;
let pifsc=document.forms['pays'].ifsc.value;
let pamnt=document.forms['pays'].amount.value;

if(pname=="" && pacc=="" && pifsc=="" && pamnt=="" ){
    alert("All fields need to be filled!!");
}
else{
if(pname==""){
        alert("Payee name needs to be entered!!");
}
if(pamnt==""){
        alert("Need to enter the amount!!");
}
if(pacc==""){
    alert("Account number cannot be empty!!");
}
if(pifsc==""){
    alert("Ifsc cannot be empty!!");
}

}
}