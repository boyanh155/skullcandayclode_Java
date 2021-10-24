<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
    <%-- Loc change --%>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>SARK</title>
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/fonts/icon_font/font-awesome/css/font-awesome.min.css">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/oneshot/home.css">
        </head>

        <body>
            <header class="Header">
                <div class="Logo">
                    <a href="#"> <img src="${pageContext.request.contextPath}/resource/assets/img/home/logo_200x200.png" height="150" width="150" alt="Amazing" class="reponsive"></a>
                </div>
                <div class="Menu">
                    <li class="Menu__Trademark"><a href="">TRADEMARK</a>
                        <ul class="Menu__Trademark__List">
                            <li class="Menu__Trademark__List__Babhabit"><a href="carteogory.html">Bad Habits</a>
                                <ul class="List">
                                    <img src="${pageContext.request.contextPath}/resource/assets/img/home/logobadhabit.jpg" alt="" class="reponsive">
                                    <li> <a href="">T-SHIRT</a></li>
                                    <li><a href="">SHIRT</a></li>
                                    <li><a href="">OUTERWEAR</a></li>
                                    <li><a href="">HOODIES</a></li>
                                    <li><a href="">SHORT & PANTS</a></li>
                                </ul>
                            </li>
                            <li class="Menu__Trademark__List__Dirtycoins"><a href="">Dirty Coins</a>
                                <ul class="List">
                                    <img src="${pageContext.request.contextPath}/resource/assets/img/home/logodirtycoin.png" alt="" class="reponsive">
                                    <li><a href="">T-SHIRT</a></li>
                                    <li><a href="">SHIRT</a></li>
                                    <li><a href="">OUTERWEAR</a></li>
                                    <li><a href="">HOODIES</a></li>
                                    <li><a href="">SHORT & PANTS</a></li>
                                </ul>
                            </li>
                            <li class="Menu__Trademark__List__UnCover"><a href="">Un Cover</a>
                                <ul class="List">
                                    <img src="${pageContext.request.contextPath}/resource/assets/img/home/Logouncover.jpg" alt="" class="reponsive">
                                    <li><a href="">T-SHIRT</a></li>
                                    <li><a href="">SHIRT</a></li>
                                    <li><a href="">OUTERWEAR</a></li>
                                    <li><a href="">HOODIES</a></li>
                                    <li><a href="">SHORT & PANTS</a></li>
                                </ul>
                            </li>
                            <li class="Menu__Trademark__List__DAVIES"><a href="">DAVIES</a>
                                <ul class="List">
                                    <img src="${pageContext.request.contextPath}/resource/assets/img/home/logodavies.jpg" alt="" class="reponsive">
                                    <li><a href="">T-SHIRT</a></li>
                                    <li><a href="">SHIRT</a></li>
                                    <li><a href="">OUTERWEAR</a></li>
                                    <li><a href="">HOODIES</a></li>
                                    <li><a href="">SHORT & PANTS</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="Menu__Store"><a href="">STORE</a>
                        <ul class="Menu__Store__List">
                            <li> <a>North</a>
                                <ul class="List">
                                    <li><a href="">Hà Nội</a></li>
                                </ul>
                            </li>
                            <li><a>Central</a>
                                <ul class="List">
                                    <li><a href="">Huế</a></li>
                                    <li><a href="">Đà Nẵng</a></li>
                                </ul>
                            </li>
                            <li><a>Southern</a>
                                <ul class="List">
                                    <li><a href="">Hồ Chí Minh</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="Menu__Contact"><a href="">CONTACT</a></li>
                </div>
                <div class="Other">
                    <li class="Other__search">
                        <input class="Other__search__input" placeholder="search" type="text">
                        <i class="fa fa-search"></i>
                        <i class="fa fa-search hidden"></i>
                    </li>
                    <li class="Other__User">
                        <a class="fa fa-user" href="${pageContext.request.contextPath}/member"></a>
                    </li>
                    <li class="Other__shoopping-bag">
                        <a class="fa fa-shopping-cart" href=""></a>

                </div>
            </header>

            <section id="Slide">
                <div class="row">
                    <div class="row-1">
                        <div class="row-1-col-1">
                            <div class="aspect-ratio-169">
                                <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/badhabit/slideshow_1.jpg" alt=""></a>
                                <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide2.jpg" alt=""></a>
                                <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/badhabit/slideshow_3.jpg" alt=""></a>
                                <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/bobui/slideshow2.jpg" alt=""></a>
                            </div>
                            <div class="dot-container">
                                <div class="dot active"></div>
                                <div class="dot"></div>
                                <div class="dot"></div>
                                <div class="dot"></div>
                            </div>
                        </div>
                    </div>
                    <div class="row-2">
                        <div class="row-2-item">
                            <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/badhabit/slideshow_1.jpg" alt="" class="row-2-item"></a>
                        </div>
                        <div class="row-2-item">
                            <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/bobui/sp1.PNG" alt="" class="row-2-item"></a>
                        </div>
                        <div class="row-2-item">
                            <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/bobui/sp2.PNG" alt="" class="row-2-item"></a>
                        </div>
                        <div class="row-2-item">
                            <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/dirtycoin/sp1.PNG" alt="" class="row-2-item"></a>
                        </div>
                        <div class="row-2-item">
                            <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/dirtycoin/sp2.PNG" alt="" class="row-2-item"></a>
                        </div>
                        <div class="row-2-item">
                            <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/bobui/slideshow2.jpg" alt="" class="row-2-item"></a>
                        </div>
                    </div>
                    <div class="row-3"></div>
                </div>
            </section>
            <!-------------------app---------------->
            <footer>
                <section class="app-container">
                    <p>Tải ứng dụng SARK</p>
                    <div class="app-google">
                        <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/appstore.png"></a>
                        <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/googleplay.png"></a>
                    </div>
                    <p>Nhận bản tin SARK</p>
                    <li> <input placeholder="Email" type="text">
                        <i class="fa fa-arrow-left" aria-current="true"></i>
                    </li>
                    </div>
                </section>
                <!-------------------footer---------------->
                <div class="footer-top">
                    <li>
                        <a href="https://www.facebook.com/76storee"> <i class="fa fa-facebook-square" aria-hidden="true"></i></li>
                    <li><a href="">Liên Hệ</a></li>
                    <li><a href="">Tuyển Dụng</a></li>
                    <li><a href="">Giới Thiệu</a></li>
                    <li>
                        <a class="fa fa-instagram" href="https://www.instagram.com/hi_hungw/?fbclid=IwAR2rgxF_ygWB_qOWBVH2qe1bKdH2uPfFD3HdQ9lnuDyq_GX00t2HxIxbFJM"></a>
                    </li>
                    <li>
                        <a class="fa fa-youtube" href=""></a>
                    </li>
                </div>
                <div class="information">
                    <p>Shop bán hàng Online với số đăng ký kinh doanh: 0929468214 <br> Địa chỉ đăng ký: S5.02 VinHome Grand Park ,Đường Nguyễn Xiển , P.Long Thạnh Mỹ, Q.9, TP.HCM, Việt Nam - 092946821 <br> Đặt hàng online : <span>0929468214.</span>
                    </p>
                </div>
                <div class="footer-bottom">
                    <div>@SARK</div>
                </div>
            </footer>


        </body>
        <script>
            /* const header=document.querySelector("header")
                            window.addEventListener("scroll",function(){
                                x=window.pageYOffset
                                if(x>0)
                                {
                                    header.classList.add("sticky")
                                }
                                else{
                                    header.classList.remove("sticky")
                                }
                            })
                            */

            const imgPosition = document.querySelectorAll(".aspect-ratio-169 a img")
            const imgContainer = document.querySelector(".aspect-ratio-169")
            const dotItem = document.querySelectorAll(".dot")
            let imgNumber = imgPosition.length
            index = 0
                /*console.log(imgPosition)*/
            imgPosition.forEach(function($ {
                    pageContext.request.contextPath
                }
                /resource/assets / img / home, index) {
                $ {
                    pageContext.request.contextPath
                }
                /resource/assets / img / home.style.left = index * 100 + "%"
                dotItem[index].addEventListener("click", function() {
                    slider(index)
                })
            })

            function imgSlide() {
                index++;
                console.log(index)
                if (index >= imgNumber) {
                    index = 0;
                }
                imgContainer.style.left = "-" + index * 100 + "%"
                slider(index)

            }

            function slider(index) {
                imgContainer.style.left = "-" + index * 100 + "%"
                const dotActive = document.querySelector('.active')
                dotActive.classList.remove("active")
                dotItem[index].classList.add("active")
            }
            setInterval(imgSlide, 5000)
        </script>

        </html>