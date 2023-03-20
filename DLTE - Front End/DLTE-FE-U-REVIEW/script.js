var trans=[];
var cnt=0;
var debitcnt=0;
let history;

function perform(){
    let amnt=document.forms['limit'].amount.value;
    document.forms['limit'].amount.value="";
    trans[cnt]=amnt;

    if(cnt==0){
        alert(amnt+"credited");
        history="<tr class='bg-info'><td>"+amnt+"</td><td>Credited</td></tr>";
    }

    if(cnt>0){
        if(trans[cnt]<=trans[cnt-1]){
            if(debitcnt>=2){
                if(confirm("THE NUMBER OF DEBIT HAS REACHED TO MAXIMUM.EXTRA CHARGE OF Rs 20 WILL BE CHARGED!! DO YOU WISH TO PROCEED")==true){
                    alert(amnt+"debited");
                    history="<tr class='bg-danger'><td>"+amnt+"</td><td>Debited</td></tr>";
                    debitcnt+=1;

                }
                else{
                    alert("TRANSACTION CANCELLED");
                    history="";
                    trans.pop();
                }
            }
            else{
                alert(amnt+"debited");
                history="<tr class='bg-danger'><td>"+amnt+"</td><td>Debited</td></tr>";
                debitcnt+=1;
            }
        }
        else{
            alert(amnt+"credited");
                history="<tr class='bg-info'><td>"+amnt+"</td><td>Credited</td></tr>";

        }
    }

    document.getElementById("hist").innerHTML+= history;
    cnt+=1;

}
