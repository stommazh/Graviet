<%@page import="Model.PostBean"%>
<%@page import="Model.Post"%>
<div class="page-content">
    <div class="mdl-grid" >
        <!--                        Post card-->
        <%
            Integer pagenumber = 0;
            if (null != session.getAttribute("pagenumber")) {
                try {
                    pagenumber = (Integer) session.getAttribute("pagenumber");
                } catch (Exception e) {
                }
            };
//                            ArrayList<PostBean> list = (ArrayList<Category>) request.getAttribute("servletName");
            Post post = new Post();

            for (PostBean postbean : post.getpost(pagenumber)) {

        %>

        <div class="mdl-cell mdl-cell--4-col">
            <div class="demo-card-square mdl-card mdl-shadow--2dp">
                <div class="card-cover">
                    <a href="#"><img src="<%out.print(postbean.getThumb());%>">
                    </a>
                </div>
                <!--Title-->
                <div class="mdl-card__actions mdl-card--border card-title-padding">
                    <a class="card-title">
                        <%out.print(postbean.getPost_title());%>
                    </a>
                </div>                                    
                <div class="mdl-card__supporting-text">
                    <%out.print(postbean.getDescription());%>
                </div>
                <div class="mdl-card__actions mdl-card--border">
                    <button id="card-<%out.print(postbean.getPost_id());%>-share"
                            class="mdl-button mdl-js-button mdl-button--icon post--icon">
                        <i class="material-icons">share</i>
                    </button>
                    <div class="mdl-tooltip mdl-tooltip--top mdl-tooltip--large" for="card-<%out.print(postbean.getPost_id());%>-share">
                        Share
                    </div>
                    <div class="mdl-layout-spacer"></div>
                    <button id="card-<%out.print(postbean.getPost_id());%>-love"
                            class="mdl-button mdl-js-button mdl-button--icon post--icon">
                        <i class="material-icons">favorite_border</i>
                    </button>
                    <div class="mdl-tooltip mdl-tooltip--top mdl-tooltip--large" for="card-<%out.print(postbean.getPost_id());%>-love">
                        Like
                    </div>
                    <div class="mdl-layout-spacer"></div>
                    <!--                                        Card menu-->
                    <button id="card-<%out.print(postbean.getPost_id());%>-menu"
                            class="mdl-button mdl-js-button mdl-button--icon">
                        <i class="material-icons post--icon">more_vert</i>
                    </button>

                    <ul class="mdl-menu mdl-menu--top-right mdl-js-menu mdl-js-ripple-effect"
                        data-mdl-for="card-<%out.print(postbean.getPost_id());%>-menu">
                        <li class="mdl-menu__item">More from the Author</li>
                        <li class="mdl-menu__item">Share it</li>
                        <li disabled class="mdl-menu__item">A disabled action</li>
                        <li class="mdl-menu__item">Report</li>
                    </ul>               
                </div>                                   
            </div>
        </div>                            



        <%}%>

        <!--Navigation-->

    </div>
    <div class="mdl-cell mdl-cell--12-col nav-bar-bottom">  
        <div class="mdl-layout-spacer"></div>
        <%if (pagenumber > 0) {%>
        <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent nav-bar-bottom-button mdl-layout--large-screen-only" href="RequestController?action=navigation_first">
            First
        </a> 
        <%}
                            if (pagenumber > 1) {%>
        <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent nav-bar-bottom-button" href="RequestController?action=navigation_pre">
            Previous
        </a>
        <%}%>

        <% if (post.getpost(pagenumber + 1).size() > 0) {
        %>    

        <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent nav-bar-bottom-button" href="RequestController?action=navigation_next">
            Next
        </a>
        <%}%>
        <div class="mdl-layout-spacer"></div>
    </div>
</div>
<%if (session.getAttribute("user") != null) {%>                        

<a id="upload-button" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored upload-button">
    <i class="material-icons">add</i>
</a>
<div class="mdl-tooltip mdl-tooltip--top mdl-tooltip--large" for="upload-button">
    Upload
</div>
<%}%>
<script src="js/masonry.pkgd.min.js" type="text/javascript"></script>
<script src="js/imagesloaded.pkgd.min.js" type="text/javascript"></script>
<!--CDN parts-->
<!--<script src="https://unpkg.com/imagesloaded@4.1/imagesloaded.pkgd.min.js"></script>
<script src="https://unpkg.com/masonry-layout@4.0/dist/masonry.pkgd.min.js"></script>-->
<script>
    var $grid = $('.mdl-grid').imagesLoaded(function () {
        // init Masonry after all images have loaded
        $grid.masonry({
            itemSelector: '.mdl-cell'
        });
    });
</script>