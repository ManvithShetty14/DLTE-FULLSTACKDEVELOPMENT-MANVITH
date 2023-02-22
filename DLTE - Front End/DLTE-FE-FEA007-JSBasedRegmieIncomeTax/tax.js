function calculate(){
    let psal = document.forms['caltax'].salary.value;

    if(psal<300000){
        document.getElementById("tax").innerHTML="No need to pay tax!!"
    }
    else if(psal>=300000 && psal<600000){
        document.getElementById("tax").innerHTML="Tax rate is 5% and they have to pay Rs"+psal*0.05

    }
    else if(psal>=600000 && psal<900000){
        document.getElementById("tax").innerHTML="Tax rate is 10% and they have to pay Rs"+psal*0.10
    }
    else if(psal>=900000 && psal<1200000){
        document.getElementById("tax").innerHTML="Tax rate is 15% and they have to pay Rs"+psal*0.15
    }
    else if(psal>=1200000 && psal<1500000){
        document.getElementById("tax").innerHTML="Tax rate is 20% and they have to pay Rs"+psal*0.20
    }
    else if(psal>=1500000){
        document.getElementById("tax").innerHTML="Tax rate is 30% and they have to pay Rs"+psal*0.30
    }
}