function calculate()
{

    // create an array to match with user input
    let loc = [
        {
            "cname": "manvith",
            "cid": "12345",
            "cpin" : "2345",
            "cstatus" : "success",
            "caccno" : "987654321",
            "cbalance": "20000",
            "caadhar" : "111122223333",
            "cpan": "qwerty123",
            "cnum" : "9972106647",
            "cmail" : "manvith123@gmail.com"

        },
        {
            "cname" :"shetty",
            "cid": "129876",
            "cpin" : "5432",
            "cstatus" : "cancelled",
            "caccno" : "246813579",
            "cbalance": "50000",
            "caadhar" : "444455556666",
            "cpan": "abcd123",
            "cnum" : "9912345678",
            "cmail" : "shetty123@gmail.com"
        }
    ]  

    // storing the user input to new variable
let uname = document.forms['login'].name.value;
let uid =document.forms['login'].id.value;
let upin = document.forms['login'].pin.value;
let ustatus =document.forms['login'].status.value;
let uaccno = document.forms['login'].accno.value;
let ubalance =document.forms['login'].balance.value;
let uaadhar = document.forms['login'].aadhar.value;
let upan =document.forms['login'].pan.value;
let unum = document.forms['login'].num.value;
let umail =document.forms['login'].mail.value;
 
// condition checking to be satisified
loc.forEach((item) => {
    if(item.cname == uname && item.cid == uid && item.cpin == upin && item.cstatus == ustatus && item.caccno == uaccno && item.cbalance == ubalance && item.caadhar == uaadhar && item.cpan == upan && item.cnum == unum && item.cmail == umail )
    {
        window.location.href = "http://127.0.0.1:5500/homepage.html"
    }
    else 
    
    {
        if(item.cname!=uname){
        document.getElementById("name").innerHTML="Name does not exist"
    } else {
        document.getElementById("name").innerHTML=" "
    }

    if(item.cid!=uid){
        document.getElementById("id").innerHTML="ID does not exist"
    } else {
        document.getElementById("id").innerHTML=" "
    }

    if(item.cpin!=upin){
        document.getElementById("pin").innerHTML="PIN does not exist"
    } else {
        document.getElementById("pin").innerHTML=" "
    }

    if(item.cstatus!=ustatus){
        document.getElementById("status").innerHTML="Incorrect Status"
    } else {
        document.getElementById("status").innerHTML=" "
    }

    if(item.caccno!=uaccno){
        document.getElementById("accno").innerHTML="Incorrect account number"
    } else {
        document.getElementById("accno").innerHTML=" "
    }

    if(item.cbalance!=ubalance){
        document.getElementById("balance").innerHTML="  Incorrect balance"
    } else {
        document.getElementById("balance").innerHTML=" "
    }

    if(item.caadhar!=uaadhar){
        document.getElementById("aadhar").innerHTML="Incorrect aadhar"
    } else {
        document.getElementById("aadhar").innerHTML=" "
    }

    if(item.cpan!=upan){
        document.getElementById("pan").innerHTML="Incorrect PAN"
    } else {
        document.getElementById("pan").innerHTML=" "
    }

    if(item.cnum!=unum){
        document.getElementById("num").innerHTML="Number does not exist"
    } else {
        document.getElementById("num").innerHTML=" "
    }

    if(item.cmail!=umail){
        document.getElementById("mail").innerHTML="Mail does not exist"
    } else {
        document.getElementById("mail").innerHTML=" "
    }

}});
}

