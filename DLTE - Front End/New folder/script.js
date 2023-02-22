function calculate()
{
    let loc = [
        {
            "name": "manvith",
            "id": "12345"

        },
        {
            "name" :"shetty",
            "id": "129876"
        }
    ]  
let uname = document.forms['login'].name.value;
let uid =document.forms['login'].id.value;

loc.forEach((item) => {
    if(item.name == uname && item.id == uid)
    {
        window.location.href = "http://127.0.0.1:5500/homepage.html"
    }
});
}

