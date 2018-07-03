<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<!--[if IE 8]><html lang="en" class="ie8 no-js"><![endif]-->
<!--[if IE 9]><html lang="en" class="ie9 no-js"><![endif]-->
<!--[if !IE]><!-->
<html class="no-js" lang="en">
<head>
    <meta charset="UTF-8">
    <title>
    Singular | Login
    </title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <script src="/singular-static/resources/singular/plugins/jquery.min.js" type="text/javascript"></script>

    <link rel="stylesheet" type="text/css"
          href="/singular-static/resources/singular/global/plugins/font-awesome/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="/singular-static/resources/singular/global/plugins/simple-line-icons/simple-line-icons.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="/singular-static/resources/singular/global/plugins/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css"
          href="/singular-static/resources/singular/global/plugins/uniform/css/uniform.default.css"/>
    <link rel="stylesheet" type="text/css" href="/singular-static/resources/singular/global/css/components-md.css"/>
    <link rel="stylesheet" type="text/css" href="/singular-static/resources/singular/global/css/plugins.css"/>
    <link rel="stylesheet" type="text/css" href="/singular-static/resources/singular/layout4/css/layout.css"/>
    <link rel="stylesheet" type="text/css" href="/singular-static/resources/singular/layout4/css/themes/default.css"/>
    <script src="/singular-static/resources/singular/global/plugins/bootstrap/js/bootstrap.min.js"></script>

</head>

<body class="login">
<div class="menu-toggler sidebar-toggler">
</div>

<div class="logo">
    <a>
        <img alt="logo" class="logo-default logo-sso" id="brandLogo3"
             src="/singular-static/resources/singular/img/logo/logo_singular.png">
    </a>
</div>

<div class="content">
    <form action="<@spring.url '/login'/>" method="POST" class="login-form">
        <h3 class="form-title">Login</h3>

    <#if RequestParameters.error??>
        <div class="alert alert-danger">
            <button class="close" data-close="alert"></button>
            <span>Credencias inválidas</span>
        </div>
    </#if>
        <div class="form-group">

            <label class="control-label visible-ie8 visible-ie9">Usuário</label>

            <input name="username"
                   placeholder="Usuário"
                   class="form-control form-control-solid placeholder-no-fix"
                   id="username"/>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">Senha</label>
            <input type="password"
                   class="form-control form-control-solid placeholder-no-fix"
                   name="password"
                   autocomplete="on"
                   placeholder="Senha"
                   id="password"/>
        </div>
        <div class="form-actions">
            <button id="btnsubss" type="submit" class="btn uppercase">Login</button>
        </div>

    </form>

</div>
<div class="copyright">
    2018 ©
    <a target="_blank" id="ownerLink7" href="http://www.opensingular.org"
       title="Soluções Inteligentes para criação de petição e análise.">
        Singular.
    </a>
</div>


<style type="text/css">
    .login .logo img.logo-sso {
        height: auto;
    }

    .content {
        margin-top: 0 !important;
    }

    .logo-default {
        width: 152px !important;
    }
</style>

</body>
<!--[if IE 8]> </html> <![endif]--><!--[if IE 9]> </html> <![endif]--><!--[if !IE]><!--></html>