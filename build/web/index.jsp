
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Graviet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/material.blue-red.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/style_1.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/material.min.js" type="text/javascript"></script>
<!--        CND Parts-->
<!--        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">-->        
<!--        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.blue_grey-red.min.css" />-->
<!--        <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>      -->
<!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>-->
    </head>
    <body>
        
        <div class="mdl-layout mdl-layout--no-desktop-drawer-button mdl-js-layout mdl-layout--fixed-header">
            <header class="mdl-layout__header">
                <div class="mdl-layout__header-row ">
                    <!-- Title -->
                    <a  class="mdl-layout-title" href="RequestController?action=homepage">Graviet</a>
                    <!-- Add spacer, to align navigation to the right -->
                    <div class="mdl-layout-spacer"></div>
                    <!-- Navigation. We hide it in small screens. -->

                    <nav class="mdl-navigation mdl-layout--large-screen-only">
                        <!-- Expandable Search -->
                        <form action="#">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                                <label class="mdl-button mdl-js-button mdl-button--icon" for="input-field">
                                    <i class="material-icons">search</i>
                                </label>
                                <div class="mdl-textfield__expandable-holder">
                                    <input class="mdl-textfield__input" type="text" id="input-field" required>
                                    <label class="mdl-textfield__label" for="input-field">Search</label>
                                </div>
                            </div>
                        </form>
                        <a class="mdl-navigation__link" href="#">Menu 1</a>
                        <a class="mdl-navigation__link" href="#">Menu 2</a>
<!--                        <a class="mdl-navigation__link" href="index_logged_in.html">Member's View</a>-->
<!--                        <a class="mdl-navigation__link" href="dashboard.html">Dashboard</a>-->
                    </nav>
                    
<!--                    Dinamic part: Get in or log out -->
                    <%if (session.getAttribute("user") == null) {%>
                    <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent getin-button" href="RequestController?action=login">
                        Get in
                    </a>
                    <%} else {%>
                    <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent getin-button" href="Account?action=logout">
                        Log out
                    </a>
                    <button id="member-button"
                            class="mdl-button mdl-js-button mdl-button--icon " data-badge="4">
                        <a><img class="avatar-button" src="http://winaero.com/blog/wp-content/uploads/2015/05/user-200.png"></a>
                    </button>
                    <%}%>
                </div>
            </header>
            <div class="mdl-layout__drawer ">
                <span class="mdl-layout-title">Menu</span>
                <nav class="mdl-navigation">
                    <a class="mdl-navigation__link" href="#">Search</a>
                    <a class="mdl-navigation__link" href="#">Link 1</a>
                    <a class="mdl-navigation__link" href="#">Link 2</a>
                    <a class="mdl-navigation__link" href="#">Log out</a>
                </nav>
            </div>
     
                
                
<!--                Content of page goes here-->
            <main class="mdl-layout__content">
                <a name="top" style="visibility: hidden;"></a>

<!--                Content wrapper-->

                <% if (session.getAttribute("page") == "login") {%>
                <jsp:include page="login_form.jsp" flush="true" />    
                <%}else{%>
                <jsp:include page="homepage.jsp" flush="true" />    
                <%}%>
                
<!--                Footer-->

                <div class="mdl-layout-spacer"></div>
                                    <div id="footer">
                                <footer class="mdl-mini-footer" >
                                    <div class="mdl-mini-footer__left-section">
                                        <div class="mdl-logo">Graviet</div>
                                        <ul class="mdl-mini-footer__link-list">
                                            <li><a href="#">Help</a></li>
                                            <li><a href="#">Privacy & Terms</a></li>
                                        </ul>
                                    </div>
                                    <div class="mdl-mini-footer__right-section">
                                        
                                        <a id="back-to-top" href="#top">
                                          Back to Top
                                          <i class="material-icons">expand_less</i>
                                        </a>
            
                                    </div>
                                </footer>            
                                        </div>
            </main>
        </div>
    </body>
</html>
