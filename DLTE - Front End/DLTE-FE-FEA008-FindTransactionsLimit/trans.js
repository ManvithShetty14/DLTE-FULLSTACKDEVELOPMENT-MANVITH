var transac = []    //Array that stores transaction amounts
var cnt = 0;    //Keep count of transactions 
var debitcount = 0; //Count the number of debit transactions
let history;    
function limit(){
    let amt = document.forms['lim'].amount.value;
    document.forms['lim'].amount.value = "";
    transac[cnt] = +amt;    //Pushing the amount to the array
    //The first transaction
    if(cnt==0){ 
        alert(amt +" credited.");
        history = "<tr class='bg-success-subtle'><td>"+amt+"</td><td>Credit</td></tr>";
    }
    //The remaining transactions
    if(cnt>0){
        //Checking if the current transaction amount is less than the previous one
        if(transac[cnt]<=transac[cnt-1]){
            //Checking if debit count is more than 3
            if(debitcount>2){
                if(confirm("You have reached the debit limit!!\nThis trasaction will cost you Rs.20 extra\n\nDo you wan to proceed?")==true){
                    alert(amt+" debited.")
                    history = "<tr class='bg-danger'><td>"+amt+"</td><td>Debit</td></tr>";
                    debitcount += 1;
                }
                else{
                    alert("Transaction cancelled.")
                    history = "";
                    transac.pop(); 
                }
            }
            else{
                alert(amt+" debited.")
                history = "<tr class='bg-danger'><td>"+amt+"</td><td>Debit</td></tr>";
                debitcount += 1;
            }
        }
        else{
            alert(amt +" credited.")
            history = "<tr class='bg-success-subtle'><td>"+amt+"</td><td>Credit</td></tr>";
        }
    }
    
    document.getElementById("hist").innerHTML += history;
    cnt += 1;
}