<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EconomicsNews</title>
    <link rel="stylesheet" href="/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/index-theme.css" type="text/css">
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/popper.min.js"></script>
    <script src="/js/jquery-3.2.1.slim.min.js"></script>
</head>

<body>
<#--navbar-->
<nav class="navbar navbar-expand-md bg-primary navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="http://localhost:8080/index"><i class="fa d-inline fa-lg fa-align-justify"></i><b>EconomicsNEWS</b></a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent"></div>
    </div>
</nav>

<#--menu-->
<div class="p-0">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul class="nav nav-pills">
                    <li class="nav-item">
                        <a class="nav-link" href="https://vk.com/id320596114">Developer account</a>
                    </li>
                    <li class="nav-item">
                        <a href="https://github.com/AlisherGM/courcework" class="nav-link">Project code</a>
                    </li>
                    <li class="nav-item">
                        <a href="http://localhost:8080/phrases" class="nav-link">Analyzed text</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<#--header-->
<div class="w-100">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <img class="img-fluid d-block" src="/image/header1.jpg"></div>
            <div class="col-md-4">
                <div class="list-group">
                    <a href="https://ria.ru/economy/20180521/1520992778.html"
                       class="list-group-item list-group-item-action flex-column align-items-start active">
                        <div class="d-flex w-100 justify-content-between">
                            <h5 class="mb-1">РИА Новости</h5>
                            <small>today</small>
                        </div>
                        <p class="mb-1">Официальный курс евро вырос до 73,33 р</p>
                        <small>Курс евро</small>
                    </a>
                    <a href="https://lenta.ru/news/2018/05/21/dirty_gold/"
                       class="list-group-item list-group-item-action flex-column align-items-start">
                        <div class="d-flex w-100 justify-content-between">
                            <h5 class="mb-1">Lenta.ru</h5>
                            <small class="text-muted">1 day ago</small>
                        </div>
                        <p class="mb-1">Великобритания решила отказаться от «грязного золота» России</p>
                        <small class="text-muted">Коррупция</small>
                    </a>
                    <a href="https://www.gazeta.ru/business/2018/05/21/11759173.shtml"
                       class="list-group-item list-group-item-action flex-column align-items-start active">
                        <div class="d-flex w-100 justify-content-between">
                            <h5 class="mb-1">Газета.Ru</h5>
                            <small>2 days ago</small>
                        </div>
                        <p class="mb-1">Болгарский поток:Москва откажет Софии</p>
                        <small>Новости энергетики</small>
                    </a>
                    <a href="https://news.yandex.ru/story/V_Centrobanke_obyasnili_rost_cen_na_benzin--d7a3eb3987b00ca2e99894d01b46fa94?lr=43&lang=ru&stid=AQUIAGH-U2CQIhQyCcb6&rubric=business&from=rubric"
                       class="list-group-item list-group-item-action flex-column align-items-start">
                        <div class="d-flex w-100 justify-content-between">
                            <h5 class="mb-1">Яндекс Новости</h5>
                            <small class="text-muted">now</small>
                        </div>
                        <p class="mb-1">В Центробанке объяснили рост цен на бензин‍</p>
                        <small class="text-muted">Энергетика</small>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<#--content-->
<div class="py-5">
    <div class="container">
        <div class="row">
            <#list articlesFromServer as articles>
                <div class="col-md-3 py-2">
                    <div class="card">
                        <img class="card-img-top" src="${articles.getUrlToImage()}" height="150" width="42" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${articles.getSource().getName()}</h5>
                            <p class="card-text"  style="height:80px;">${articles.getTitle()}</p>
                            <p class="card-text">${articles.getPublishedAt()}</p>
                            <a href="${articles.getUrl()}" class="btn btn-primary">View</a>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</div>

<#--footer-->
<div class="bg-dark text-white p-5">
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
                <a href="https://www.facebook.com" target="_blank"><i class="fa fa-fw fa-facebook fa-3x text-white"></i></a>
            </div>
            <div class="col-4 col-md-1 align-self-center">
                <a href="https://twitter.com" target="_blank"><i class="fa fa-fw fa-twitter fa-3x text-white"></i></a>
            </div>
            <div class="col-4 col-md-1 align-self-center">
                <a href="https://www.instagram.com" target="_blank"><i
                        class="fa fa-fw fa-instagram text-white fa-3x"></i></a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 mt-3 text-center">
                <p>© Copyright 2018 BY BOSSWEB - All rights reserved.</p>
            </div>
        </div>
    </div>
</div>
</body>

</html>