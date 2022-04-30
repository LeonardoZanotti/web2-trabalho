<%-- 
    Document   : login
    Created on : 23/07/2021, 21:36:55
    Author     : jessi
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="/jsp/erro.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
    </head>
    <body>
        <div class="wrapper page-extra">
            <nav class="top-section navbar">
                <div class="main-logo">
                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="220px" height="69px" viewBox="0 0 220 69" enable-background="new 0 0 220 69" xml:space="preserve">  <image id="image0" width="220" height="69" x="0" y="0"  xlink:href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAR0AAABFCAQAAADdyfreAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAAmJLR0QA/4ePzL8AAAAJcEhZcwAADsQAAA7EAZUrDhsAABVISURBVHja7V15eBRF2v/1XDkIRxIgQgQB5RICyUKAhQjRRRABEWUlFogQhc0TRFE24i6ICmaXW2CzEVAiILQ3CoIISICgoqACOZAQiInmIpgQck0mM931/THTMz09PUlPhySL3/zyPNBHvUdXvV311ltv9QBeeOGFF1544YUXXnjhhRde3Bwwzqcvd79SwPKtrZQURBvaZU2BWuqkx6AHZ7m+8FBrP8cfGul7qSX7+PsJy0fPbkuYpvNrGmYaXh61c2HuaWo5uVUtD8KYjZSn3IbHWvtp/mjQiU+IIWwSNH3G9BkDgGad/Gtq7uncc9dLWNqySs2/reefeg65a9SgcQAABugeSXxYkypmWjBgAGha9hn++HAyHf9OogGMGTB6wGgA9PQnI/ecObyjrCXUebJ95MTIR4dNlQ6k3Qd36Y1MVSy9JtNMcDKdu6PgOkgxw6YNm1ZaPG3XmT2Xf2AtzaUI0d41LPKRYTGdb5e9zfQcpNJ0tAKH5tLcCxCfQ5tpQ+DTj2ybG9ft5kuO67ZtXvpRyjckfP8qlU8VYK6jlPIbSOvW7h8aJOD3Itooygvfe3F255sndXan914sL2xcbrrK+RFp5zWd5oFowPJvH3xb4wSBXWNWRT0V9Ubqu2xNU4WTNvfNHP/87X2VlO0eRnSqhstb2tchGgAMNOBZrrV1aQDrpzb+7jtw8ftNhOjUSyO6TeTiDx4I5BcNUCUn8NbtdVZOvPK9xcRbqkoPric+ra1NAzi41hPToZTyZz5/IUKdrBcGnvnUQ2k0SVXj37qms2jAr1nCs5tq3v9na+sjhb3fIPo+ozykZYZO6jawx5LvPvR0INkU81hiSC9PVe0ZAVbFE96yM6vOvdt1FY4N/iH9W1sfKRyegKHr3Z6Th/RYsCtmdVxP5RRxbfe9toD13HCAOyKIGr/FQ9NJfthYTjnHn7l2T4IKqTcBpb9U2mNp9bVXs5zvHltPLWI9y/MSo1tWP3tjBHf1bauKAzP5+fi344OUFZ6viX9z8svqeoI7wuGrRj8Py/tDD43ozw/q6qXJKM5gE3IzOTPlq8tT34pZKbltgNZJz3bwa1n97ANWaB/1TC6kJZcrK/lfftzlMJVDSEBQ8B34udlrhIKXnLcSWB5707+AAQzMrNHlNg/q9FpY0MLL1nbT6dpHrVdQXHQ4yXpEtNJpJGHAgALQs/XWK2kfjnvet506SXfcrcJ0PH0qvYSCscejWx4MGFjAy67e6SXnLa6lzXSIIVRRdEUORzaklAFA3J0Ju9EG/AoKCsb2BwAUJphX1L48ha0B1l24/93x89VVZI8wfNLsNWICBx5iL7DVHG2WIwz00BKtTFSnztYfCtoxLa2n0OvoQgeqY5B3+ch/AIDopi3tNbyBgnRyPLsGANLeHR+v0tsZpHr9XDHiP/h6L3joVmeECq78TQrGWZNYlGYhEC2sgyUDHbSEstXO9+99nvwdhqgn5mzytUZ8GJjtlLzaXAfCwABGNBRyrLkxkrZV1zyNs1jx6Rorh8XDG16DopSrn90RAIjPT6nqZJVeJm08royO6uI6BTlWmWa65zUgIezY1pIcUzXlKMebjRUF5w+/kaA4pkWYt+akHyzLN1XzFspRzlRdUXhuf1KM2/K6zC8pTznKUd76V5BJZCciyXOM9VY9y39PHAOsn3puX0WRxUQ5yllMlVezj+96PlbBGgEAEL+EoYc35Z+v/t1Kz9XXXi84t39FwuAGyeJub6zh3WH5OGvlfLW98bLbFwIA0W57QZ0syj3dpWVMh+gcprN/Y8YRc52rMua6jKPL7mmMU2zAF/++USRXuTx3veC9BLmEOqLPPOZctuAyCZQ1nVgjZzOd62xC8c8ycvjq379cF9upMT1XTsr5zlwvp6bZmLF/2Qi3hCtGqDOdklLiDwAz29XVNl46N8NamrQz1agyHX7F6JYxHaDgok0ktTSgUM31j19piEvy9JIcScXyzie/pK8Y60qXeci5XEEWkQ1MJD9ptAiceMmBWErRxVWT3GsZG/j1O/VyZuN4zrKDq4lk8m9zBtt2UFynTqPouT2oA4DwB3wURBV6DrCFHc1nv/KsIQX4KddTVl/P6RqeYPl3eOjVw26TX9lnntwScpekW2GcT3qEzWeTn3Ah1Ui8QQ3kI/bUoSdjPZdxlxl06Tv3bRkpAICEfi9+NnK2Xo8G4B80LuG5nbFOg6ZgOoFQhO2v/z2a/Vd2OnjwAOiRzSwPEE3YXxSRM2HRxAcAf/BNUOuDnz+1c9kLw78+qEy+yrDlzQAFBQ/e0VhW6BE99zPZXKJts6ck+reX4SHhENhp+vpVD0mI62yy7DXnNmrj/Gow8jKAwJDpa1c96Eoe6zdrY5/RjJQnlXLQYOi02WvFV2wzrLbByuY8RReLMw5cOLAWxpCe4RMHj153DgCg7RetrP77jzm0BSbWRE6e33/+6LkDV3PhCx24b3dFTVBAzvipjAg1DfW1V06nH7zy05KvgKXDB44e8ugdQ/X2zkiPqLmJXy054kyTOHpKor9I29qaiyd+/CR9f1JprE/ElPDJg6a0bStUeVDHaf/OTkupcJQeOBkg+mmvTf6HrYEUTL0pqkoufJV1LPtMYSZ0EQ9GjBvwYEgPB1lg5wnPLf5CSjVr3d3jHGV4FF85+2l6atYxML2GDIyOnN59oDAJ12B4zPuZMeslDL54RYmrUcOTnqQzCSaSzi02RLGnxMu7e6SzMvLdL3ra7CS4qb7OD4ee6S11ZpdF//y945F5euozKf0p1nHfQk/ve0ayzhfb7vgus6jEvrWuOux5VShRcEk+wSV5ljDDMnIfL3V5dp+tcWXXHbVXZ94hiaitn3BDdL+sYms88SM6onVwWPd4yVVHiaLsRfaVTmHA6qioOq+AA0WVdK7fPVx5kwTLJ6hqihUljvkGKJfURNiMhcOvPyXlSOMky4+vGfvt+7y9aP/7V00U3191f//xgrWZkfr2hseTfnHmkFK5NfZQkuDAaDH08UWuy8+iTQZuUtbsJYxV2SelN1nTvM0bH/0tVzj30Q2f6fwSDH/C4eUWFiQ/eXwHa2QtQgCS6MD8uD95VmG+UKZzzzHThWObQgGNTt4A4NJR1Mm5a117Kw7xMbfLr5UZv9+thFzFgNX0NShZDilVKU9f/lE4C/AfOF58N2JSuyCB+OKx7X+Ty6hk6/csyT0rnAV1lfEXxcFIdzXsiCbL6rk89eOXKu1h1C5hfxL5O0vDe48VyGsqD7zy85cSPXkAlsvHjm4w2TTR6vuOFZLOBF8nREkdVpaF3ZufXllM9DALa1IA4EkKRZc7nc+JAf6g7TpXKNrd2YJustgBkEVKzT07ug+xzpm16DZMfC80XCCv5dJ2QUv0sDgvJhAGqKs9u7dnhHX0N6BbuIuIxhc0xQblJur9wkfDH/3zdGtBvzY9wnFAuNNtYFt7l3Hp5Ind0BMfmEEBcOBAoYUGOmhOfDb6bz36Wct1vKvvcKQBHpoO+SdQUZF/4dezv54NzSw8z9YBANF2vFMJtRWdehONdWsyMQT3Cu3ftf+gSYNHKO21WtBNdrzDbhsw8+iNq762musQ6rgeG9DB7tm00c7fNn8bKLDbuf9iRP8CYNCpj1AzMjq46z0dSwbUff+akzZkurWr0CFQtFmpc2+HAxUxcbfRtvAhB/tV3zbBtie10SobsACgQ4cOIwePBOW4/J8QzRoB+ATfpZQaCL4TvqgFSIcVqb3CPV3LakFfRwHWXZiTG2IzHa1vbNuUKuvxncP9pJMBiaHIQeMDTfMkThRm15p8fKwK6EX9dofbnXxvRQuoGmi0whEAwMfTJmG0ul6RtoV/jZ/CqBAA+AfaYmz6XhGeL4Jq1SfSN0/ejb2p/QLuHGq/6urSUntciLdHh6gLL+kVsZssrz8vKuG+NnlHuaAeouvO0U7qpJv0T6hDi+Dt2h6y6qrHlUZhgdX94io9oL5RCKuXVCNTVY2iukW2L0vQkIHbjaS+rrzQftWdETBOySgSvuUF7rm7NR2lSRf2e1WloqvScCLjlotd47raG787KVd9zYOqpNfy96xdOIAx2BIgTGWXlBNfy7ZSsbWMduHgPauv/eaJAVX/7oGeNwsNNEkb+0BfX7XOXgtXThtviOtL1MOI32PJ+81VuWTlaGSOnEGVmE5AoN4gFK8V1WBFgdN02TkGLe1vbDpTE19nLWAbAKpLoRR0Rh+UgGdrhQss//BF5e1Qmus43phx7ZVPliBod4nSoavK816n6QlQbhexNvw1qLtwfC3HcT2l6oUrXW3uaHHRuonFWdCBgrMtvjjeb6tvIwzC9S4CxL2O/HM4TEcDt4N533v8bJzMuCp6za9mm21EHL5Y/f4S+EEPCg004GEBBQMNGGigAQcGDMywgAoTeMF0SpQ3xbAxp7c7vx8lVyR5sg2gKEd8xtYBG+5XLBvV15WXbQqc9l647RWHk7a2t9mC/G/Fd3LT+o2xWlynrqNjprwENwlTRAsdOFjcbEdq3HQccOtgJ/Qb/Jhg/TWmX8457uScrijxuw0AtIh46CRbeJGtAggDPwAWMNADYMDZNLGwVTLKVSk3HUTGQOJUF2Qpp/5NUpb4RsYo7xmqK5RLcn5CD+HroGMM8osAnyUOeVhQvKLinNPq0A/7yousRzqMXbxjsTwH4hM6YsGBqHlwt7PT0d8xbvoUewnGoJHNXYhtMys5xL6fK+/rrGOOe+suZX4iWFxovyc3B/UlvgBLYYQRZphRDx4maOA/aeG8Lb7BzpxtClWVKu83ho39r44YxCHBgvOKqamxUnJFN2ycMrmAKtNRB/vz6DAuHhYkwijuGWLbx/xrTLywlMfj7LvLT4nJl/8wfPf4BGu7+iNmZWjvoOVJvzqLiO3wwILx/2jn13c0TOwWN1oIMMsMZ1bRNrQ3zH7bsGCRJHd72ajHV/cdKTRNteWbt5zHiyObwibe1gMAGNw94qXPPvwH9oKCAQ8OGmjBwaf/yKmL+93DwM8Hc1NEjo0wYHngfuoQEFzNkQAtExn17F4AAJeVNiBaCW3qLqHr3hR15juOQhPQUWdQ3qAt4esQXzjti/D3m7L4zzNOpAR9WJ4LM/jQQWNmjJgR1MXBuODioTekXD5Z0W9cL1tqpgF/eerPT8R+nXUoO+3174CEsL6jBk/s+5cAPwZAoD5mPRDvYjzER7TrQQN/UgsqiUjrYa87Brd1efbjCd+lbv72Q3DgwQyeED1n0BRfu5o8fkxZ8IGzjDWXhvx3aqLBYOUQ2vO594tzL6ReOJ5+vO4GmIjx/UYOmti1j9VIhj4EDnNTpC2wZYInWYLvJO7bWZxPecqttPUYHylaead00yxr+ZUPUgvli/P2vfHOS8rlUv45jz9ZQDrbVs4fV1Y+OcZYIZdpRylnMVYZK13zG8tK5PJggFWTiuU//iLDu6zKefk085BcOWNV8iyhxLHN7lqsvt5Ya6y21EuFZhyPlU3nSt1q5pTpydE0kYELA1a58gELmC1snWei5+IwAKQfnfaqAkKafgAACBMdBy1w2x2TF3pmCCoGLE97HQPayNNotHKx7MprH7/omgUDAIv318+ZsznUdVO1C3cev50T+4BEj/aymgeIvEx/d0+m17tm/FHkpu+MS5F11t/+m8UUPVfv6m+58K8uvfydS6mlfai85TXaD8QGAgDxK/qt8cKnbQtvsR3VZUKbqonHy58kxMNeZ6axSizT3EDF8LQgc+UDDXF75q5zX1oaeaobxa7J7Zkn5EoaafI8ocSxbZK6aUCChZ7e80yoey2JLiXu+lXaICymjIPLIsVUtnlEkSchQSfLjHwEAGBOVfB52hObrf9HTlcXbSnIRmO7gpoOrXMcp/jyh69VFMrNz2vKDq9ZFvXSlw0xS7q8+sGtT+VluZs5V5Uee3PJkMfXKN435WZ1nOKbD07tqTfL3SnJS3lq2CNJhe6ZspbYzS/fc2JLzQ35+5w59/uts8ImLD8jvmobsOrqy/KCVXx9Ahj6GLYBrMV3y4xXG54IX81L+NxGM1WNJKDogpt5xs2ECfXizyJUXPl845HNUY+OnNa1v3+gVg/wltqKop/PfJq6K0XB5ILl2RSyq9fI6Om9ozp29/XXaAHK19fWlOX99NPnc7e7IauQjSZVwhFZuQHevrsWlrryjD0bQ/uOeSx8cnCoTxtGA5jrqspzz5zc9cO+RrfhAUi6lBQX+2rU1KGTQgcFBBr8AcBcV19TmnMp7ejuwkxX47a9/cR/8QeDJjUuQA5LoxK/AYAd8bP+AwbuvAu6/uFF+wBgyYjXTynnLsYHS2MSPaUhITvydT6gG2csfE8hhRZaW7aKFlrwwqcCbGFCCgZUze5KooXWuvxw87+H79haTDRgmiKBaOBv05MH39DuT3sQvChbrencN9dqOofeNPAwQAc9dLYPeDCwrn7Uw4xKq+EA981TJwe0MLtJ9asQLGcbFnjn4dHeHCrX4O18m0dnqZZqOfGo9pDk7Xlq939Sfkm4cjlLItTLWeSBHAF2N/mW+yDc/zrs3kkT3mh634PKC9/3tNoFSZ4r9mCF3ovmhsN0clQnQ/H1HvxqTP1VtXIKL7fA/MoLxbCbTnVFpfLECxEKsraQCTuVl5+wfMucglzl5R0ozFQyU/CipeCYTtcXZnhMTdNS1j4S95FnRHE71j6Qtt3zvqdI3W9ECLhlv2R6C2Dv6545rfnnN89RL21zbP4Fz7zklR54VA7Y3eQZrV2/fzSIgng5Z5T3BGV57y1aNiruHfWC41KWRb6XUFakmIDmqet1Wu0zkv+PQIKVTZuNFXtfiw9tujwAiO+xN9F4Q4nU37KJqo+72lfOvb1O84G0L7nc2CBlvH5kZULvmys3IezIxrrKxkzn2HZ1PyhpN52ZrV2/f2AQv5O7GjKbiyd3zl/QDL+GBQDP9WZfvHKuoV7vnWdVPlUnr+m0ADbOlG08vvzXL9esGNXcv41C9KsnnHjLTf/DrxivkqvXdFoCpJMkOYU33jj7xZbYpxV9QuXm4Lke7KKc76V5erUVcR5sTnZ6JpXf1/GiMTjn2deZjfo21t1Cl7699E32txdO1ZW37I94bczDOrIpuFv/EX2i+o6+vb91G0neeXUBSzgSv71xnZsMJ9Nhq579qHO/jBOZJ7K+Rl3rxW5ZM3KRC5Zo4RP2QPjY8HsLTrOVKpnxZfnQSlfBvWg6XN5F520y/wsgvtCxniYCiOk7wBcmVLT0r7V74YUXXnjhhRdeeHHr4v8AehrrBAV6LZYAAAAldEVYdGRhdGU6Y3JlYXRlADIwMjEtMDctMjRUMDA6MzY6NTArMDM6MDCfLuL1AAAAJXRFWHRkYXRlOm1vZGlmeQAyMDIxLTA3LTI0VDAwOjM2OjUwKzAzOjAw7nNaSQAAAABJRU5ErkJggg==" />
                    </svg>
                </div>
            </nav>
            <div class="container">
                <div class="row login">
                    <div class="col-md-12"> 
                        <form class="login-form shadow" action="${pageContext.request.contextPath}/LoginServlet?action=logar" method="POST">
                            <div class="flex-row">
                                <label class="lf--label" for="username">
                                    <svg x="0px" y="0px" width="12px" height="13px">
                                    <path fill="#B1B7C4" d="M8.9,7.2C9,6.9,9,6.7,9,6.5v-4C9,1.1,7.9,0,6.5,0h-1C4.1,0,3,1.1,3,2.5v4c0,0.2,0,0.4,0.1,0.7 C1.3,7.8,0,9.5,0,11.5V13h12v-1.5C12,9.5,10.7,7.8,8.9,7.2z M4,2.5C4,1.7,4.7,1,5.5,1h1C7.3,1,8,1.7,8,2.5v4c0,0.2,0,0.4-0.1,0.6 l0.1,0L7.9,7.3C7.6,7.8,7.1,8.2,6.5,8.2h-1c-0.6,0-1.1-0.4-1.4-0.9L4.1,7.1l0.1,0C4,6.9,4,6.7,4,6.5V2.5z M11,12H1v-0.5 c0-1.6,1-2.9,2.4-3.4c0.5,0.7,1.2,1.1,2.1,1.1h1c0.8,0,1.6-0.4,2.1-1.1C10,8.5,11,9.9,11,11.5V12z"/>
                                    </svg>
                                </label>
                                <input id="login" name="login" class="lf--input" placeholder="Usuário" type="text">
                            </div>
                            <div class="flex-row">
                                <label class="lf--label" for="password">
                                    <svg x="0px" y="0px" width="15px" height="5px">
                                    <g>
                                    <path fill="#B1B7C4" d="M6,2L6,2c0-1.1-1-2-2.1-2H2.1C1,0,0,0.9,0,2.1v0.8C0,4.1,1,5,2.1,5h1.7C5,5,6,4.1,6,2.9V3h5v1h1V3h1v2h1V3h1 V2H6z M5.1,2.9c0,0.7-0.6,1.2-1.3,1.2H2.1c-0.7,0-1.3-0.6-1.3-1.2V2.1c0-0.7,0.6-1.2,1.3-1.2h1.7c0.7,0,1.3,0.6,1.3,1.2V2.9z"/>
                                    </g>
                                    </svg>
                                </label>
                                <input id="senha" class="lf--input" placeholder="Senha" name="senha" type="password">
                            </div>
                            <input class="lf--submit" type="submit" value="Login">
                            <a class="lf--forgot" href="${pageContext.request.contextPath}/LoginServlet?action=autoCadastro" >Cadastre-se</a>
                            <c:if test="${msg != null}">
                                <div class="alert alert-danger" role="alert">
                                    <c:out value="${msg}" />
                                </div>
                            </c:if>
                        </form>
                        <div class="footer">
                            Em caso de problemas contactar o administrador:<br>
                            <a href="mailto:${configuracao.email}">
                                <c:out value="${configuracao.email}" /> </a>
                        </div>
                    </div>
                </div>   
            </div>          
        </div>
    </body>
</html>