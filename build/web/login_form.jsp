<style>

    #login-form-error-message{
        display:none;
        text-align:center;
        overflow:hidden;

    }
    #login-form-server-error-message{
        text-align:center;
        overflow:hidden;
    }
    .logo img{
        width:120px;
        height:30px;
    }
    .mdl-card__menu{
        left:20px;
        right:auto;
    }

    .avatar-2{
        background-image: url(img/avatar.png);
    }
    .avatar-3{
        background-image: url(img/K_avatar.png);
    }
    .login-form{
        width:80%;
        margin:auto;
        padding-bottom:30px;
    }
    form button{
        width:100%;
        margin-top:10px!important;
    }
    .mdl-layout__content{
        background-color: #f1f1f1;
    }
    .form-title{
        font-weight:normal;
        color:#636363;
        margin:20px 0 0 0;
        text-align:center;
    }
    .email-title{
        text-align:center;
        margin:16px;
        overflow: hidden;
    }
</style>
<script>
    function show(target) {
        document.getElementById(target).style.display = 'block';
    }
    function hide(target) {
        document.getElementById(target).style.display = 'none';
    }
    function check(field) {

        if (document.getElementById(field).value.trim().length) {
            show('spin');
            hide('field');
            hide('button');
        }
    }

</script>
<div class="page-content">
    <%
        if (session.getAttribute("user") != null) {
            response.sendRedirect("RequestController?action=homepage");
        } else {
            String email = null;
            if (null != session.getAttribute("email")) {
                try {
                    email = (String) session.getAttribute("email");
                } catch (Exception e) {
                };%>
    <script>
        function validateField(password) {
            var regex = /[0-9a-zA-Z!@#$%]{6,64}/;
            return regex.test(password);
        }
        function validate() {
            $("#login-form-error-message").text("");
            var field = $("#password-field").val();
            if (validateField(field)) {//valid
                show('spin');
                hide('field');
                hide('button');
                $('#form').attr('action', 'Account');
            } else { //not valid
                $("#login-form-error-message").text("Oops! Invalid password");
                $("#login-form-error-message").css("display", "block");
                $("#login-form-server-error-message").css("display", "none");
                return false;
            }
            return true;
        }
        $("form").bind("submit", validate);
    </script>  

    <div class="mdl-card mdl-shadow--2dp account-wrapper">
        <h4 class="form-title">Account</h4>                     
        <div class="login-form-avatar avatar-3"></div>
        <p class="email-title"><%out.print(email);%></p>
        <form id="form" onsubmit=" return validate();" action="Account" method="post" name="Form" class="login-form">
            <div id="field">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="password" id="password-field" name="password" required>
                    <label class="mdl-textfield__label" for="password-field">Enter your password</label>
                </div>
                <div id="login-form-server-error-message">${message}</div>
                <p id="login-form-error-message"></p>
            </div>
            <div class="mdl-spinner mdl-js-spinner is-active" id="spin"></div> 
            <button id="button" onsubmit="validate(); return false;" type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
                Login
            </button>
        </form>
        <div class="mdl-card__menu">
            <a href="Account?action=back" class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
                <i class="material-icons">keyboard_backspace</i>
            </a>
        </div>
    </div>

    <%} else if (session.getAttribute("notregister") == null) {%>


    <div class="mdl-card mdl-shadow--2dp account-wrapper">
        <h4 class="form-title">Account</h4>                    
        <div class="login-form-avatar avatar-2"></div>
        <form id="form" action="Account" method="post" name="Form" class="login-form" onsubmit=" return validate();">
            <div id="field">
                <div class="mdl-textfield mdl-js-textfield">   
                    <input class="mdl-textfield__input" type="email" id="email-field" name="email" required>
                    <label class="mdl-textfield__label" for="email-field">Enter your email</label> 
                </div>            
                <div id="login-form-server-error-message">${message}</div>
                <p id="login-form-error-message"></p>
            </div>
            <div class="mdl-spinner mdl-js-spinner is-active" id="spin"></div> 

            <button id="button" onsubmit="validate(); return false;" type="submit"  class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
                Continue
            </button>
        </form>
    </div>
    <script>
        function validateField(field) {
            var regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return regex.test(field);
        }
        function validate() {
            $("#login-form-error-message").text("");
            var field = $("#email-field").val();
            if (validateField(field)) {//valid
                show('spin');
                hide('field');
                hide('button');
                $('#form').attr('action', 'Account');
            } else { //not valid
                $("#login-form-error-message").text("Oops! Look like your email is not correct");
                $("#login-form-error-message").css("display", "block");
                $("#login-form-server-error-message").css("display", "none");
                return false;
            }
            return true;
        }
        $("form").bind("submit", validate);
    </script>  
    <%} else {%>
    <script>
        function validateNewPasswordField(password) {
            var regex = /[0-9a-zA-Z!@#$%]{6,64}/;
            return regex.test(password);
        }
        function validateNewPassword() {
            $("#login-form-error-message").text("");
            var field1 = $("#new_password_field").val();
            var field2 = $("#re_new_password_field").val();
            if (field1 !== field2) {
                $("#login-form-error-message").text("Oops! Passwords are mismatch");
                $("#login-form-error-message").css("display", "block");
                return false;
            } else {
                if (validateNewPasswordField(field1)) {//valid
                    show('spin');
                    hide('field');
                    hide('button');
                    $('#form').attr('action', 'Account');
                } else { //not valid
                    $("#login-form-error-message").text("Oops! Invalid");
                    $("#login-form-error-message").css("display", "block");
                    $("#login-form-server-error-message").css("display", "none");
                    return false;
                }
                return true;
            }
        }
        $("form").bind("submit", validateNewPassword);
    </script>    
    <div class="demo-card-wide mdl-card mdl-shadow--2dp account-wrapper">
        <h4 class="form-title">Account</h4>                     
        <div class="login-form-avatar avatar-2"></div>
        <p class="email-title"><%out.print((String) session.getAttribute("notregister"));%></p>
        <form action="Account" method="post" name="Form" class="login-form" onsubmit=" return validateNewPassword();">
            <div id="field">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="password" id="new_password_field" name="new_password" required>
                    <label class="mdl-textfield__label" for="new_password_field">Enter new password</label>
                </div>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="password" id="re_new_password_field" name="re_new_password" required>
                    <label class="mdl-textfield__label" for="re_new_password_field">Re-enter new password</label>
                </div>
                <div id="login-form-server-error-message">${message}</div>
                <p id="login-form-error-message"></p>                
                <button id="button" onsubmit="validateNewPassword(); return false;" type="submit"  class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
                    Create Account
                </button>
            </div>
        </form>
        <div class="mdl-card__menu">
            <a href="Account?action=back" class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
                <i class="material-icons">keyboard_backspace</i>
            </a>
        </div>
    </div>     
    <%}%>
    <%}%>

</div>

