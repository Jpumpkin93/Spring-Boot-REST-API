

$(function () {

    fetch('http://localhost:8080', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer '+ getJwtToken()
        }
    });


    var TOKEN_KEY = "jwtToken"

    // FUNCTIONS =============================================================
    function getJwtToken() {
        return localStorage.getItem(TOKEN_KEY);
    }

    function setJwtToken(token) {
        localStorage.setItem(TOKEN_KEY, token);
    }

    function removeJwtToken() {
        localStorage.removeItem(TOKEN_KEY);
    }

    function createAuthorizationTokenHeader() {
        var token = getJwtToken();
        if (token) {
            return {"Authorization": "Bearer " + token};
        } else {
            return {};
        }
    }

    $("#loginForm").submit(function (event) {
        event.preventDefault();

        var $form = $(this);
        var formData = {
            id: $form.find('input[name="id"]').val(),
            password: $form.find('input[name="password"]').val()
        };
        doLogin(formData);
    });

    function doLogin(loginData){
        $.ajax({
            url: "/loginCheck",
            type: "POST",
            data : JSON.stringify(loginData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (data) {
                alert(data["msg"]);
                setJwtToken(data["data"]);
                window.location = "/board";
            }
        });
    }

    $("#signUpForm").submit(function (event) {
        event.preventDefault();

        var $form = $(this);
        var formData = {
            id: $form.find('input[name="id"]').val(),
            password: $form.find('input[name="password"]').val(),
            name: $form.find('input[name="name"]').val()
        };
        doSignup(formData);
    });

    function doSignup(signData) {
        $.ajax({
            url: "/signUpCheck",
            type: "POST",
            data : JSON.stringify(signData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function (data) {
                alert(JSON.stringify(data));
                window.location = "/login";
            }
        });
    }

    $("tr").click(function (){

        var tr = $(this);
        var td = tr.children();
        var number = td.eq(0).text();

        $.ajax({
            url: "/postDetail",
            type: "GET",
            data : "number=" + number,
            contentType: "charset=utf-8",
            headers: createAuthorizationTokenHeader(),
            success:function (data) {
                console.log(data);
            }
        });
    });


});


