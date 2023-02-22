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
    
});
}

