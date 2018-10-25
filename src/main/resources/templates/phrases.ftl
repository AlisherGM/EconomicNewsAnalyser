<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Phrases</title>
    <link rel="stylesheet" href="/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/index-theme.css" type="text/css">
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/popper.min.js"></script>
    <script src="/js/jquery-3.2.1.slim.min.js"></script>

<body>
<#--menu-->
<nav class="navbar navbar-expand-md bg-secondary navbar-dark">
    <div class="container">
        <i class="fa d-inline fa-lg fa-bars"></i>
        <a class="navbar-brand" href="" http://localhost:8080/phrases"">&nbsp; Article</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/index">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="https://drive.google.com/file/d/1i2pvoGXOFn7G-0qULE2TCFR6rljGzkg1/view?usp=sharing">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="https://vk.com/id320596114">Contact us</a>
                </li>
            </ul>
            <form class="form-inline m-0" id = "date" name ="date" method="post" action="/phrasesByDate">
                <input id="party" type="datetime-local" name="partydate" class="date-cell" value="2017-06-01T08:30">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<#--header-->
<div class="text-center py-0" style="background-image: url(/image/header2.jpg);width=100%;background-size: 100%;">
    <div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <h1 class="display-3 mb-4 text-primary">Анализ новостей</h1>
                <p class="lead mb-5">Сервис по анализу экономических новостей и рессурсов.</p>
                <a href="http://localhost:8080/index" class="btn btn-lg mx-1 btn-secondary">Главное</a>
                <a href="http://localhost:8080/phrases" class="btn btn-lg btn-primary mx-1">Обновить данные</a>
            </div>
        </div>
    </div>
</div>

<#--content-->
<div class="text-center py-0">

    <div class="container py-5">
        <#list phrasesFromServer as phrase>
        <div class="list-group mb-3" style="margin-left: 5%; margin-right: 5%">
                <a href="${phrase.getUrl()}" class="list-group-item list-group-item-action active text-right">
                    <#if phrase.getSource().getName()??>
                        ресурс: ${phrase.getSource().getName()} |
                    </#if>
                    <#if phrase.getAuthor()??>
                        автор: ${phrase.getAuthor()} |
                    </#if>
                    <#if phrase.getPublishedAt()??>
                        дата публикации: ${phrase.getPublishedAt()}
                    </#if>
                </a>
                <a href="${phrase.getUrl()}" class="list-group-item list-group-item-action text-left">
            <#if phrase.getDescription()??>
                ${phrase.getDescription()}
            <#else>
                Подробнее на сайте
            </#if>
        </a>
    </div>
    </#list>
    </div>
</div>

<#--footer-->
<div class="py-5 bg-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <p class="lead">Sign up to our newsletter for the latest news</p>
                <form class="form-inline">
                    <div class="form-group">
                        <input type="email" class="form-control" placeholder="Your e-mail here"></div>
                    <button type="submit" class="btn btn-primary ml-3">Subscribe</button>
                </form>
            </div>
            <div class="col-4 col-md-1 align-self-center">
                <a href="https://www.facebook.com" target="_blank">
                    <i class="fa fa-fw fa-facebook fa-3x text-white"></i>
                </a>
            </div>
            <div class="col-4 col-md-1 align-self-center">
                <a href="https://twitter.com" target="_blank">
                    <i class="fa fa-fw fa-twitter fa-3x text-white"></i>
                </a>
            </div>
            <div class="col-4 col-md-1 align-self-center">
                <a href="https://www.instagram.com" target="_blank">
                    <i class="fa fa-fw fa-instagram text-white fa-3x"></i>
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 mt-3 text-center">
                <p>© Copyright - All rights reserved.</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>