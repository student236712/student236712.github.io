<!DOCTYPE html>
<html>
<title>Diseases history analise web tool</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
.w3-row-padding img {margin-bottom: 12px}
/* Set the width of the sidebar to 120px */
.w3-sidebar {width: 120px;background: #222;}
/* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
#main {margin-left: 120px}
/* Remove margins from "page content" on small screens */
@media only screen and (max-width: 600px) {#main {margin-left: 0}}


</style>
<body class="w3-black">

<!-- Icon Bar (Sidebar - hidden on small screens) -->
<nav class="w3-sidebar w3-bar-block w3-small w3-hide-small w3-center">
    <!-- Avatar image in top left corner -->
    <img src="/w3images/avatar_smoke.jpg" style="width:100%">
    <a href="#" class="w3-bar-item w3-button w3-padding-large w3-black">
        <i class="fa fa-home w3-xxlarge"></i>
        <p>HOME</p>
    </a>
    <a href="/doctor" class="w3-bar-item w3-button w3-padding-large w3-hover-black w3-teal">
        <i class="fa fa-user-md w3-xxlarge"></i>
        <p>DOCTOR</p>
    </a>
    <a class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-address-card w3-xxlarge "></i>
        <p>PATIENT</p>
    </a>
    <a href="/registrant" class="w3-bar-item w3-button w3-padding-large w3-hover-black w3-teal">
        <i class="fa fa-address-book w3-xxlarge"></i>
        <p>REGISTRANT</p>
    </a>
    <a href="#photos" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-user w3-xxlarge "></i>
        <p>MED WORKER</p>
    </a>
</nav>

<!-- Navbar on small screens (Hidden on medium and large screens) -->
<div class="w3-top w3-hide-large w3-hide-medium" id="myNavbar">
    <div class="w3-bar w3-black w3-opacity w3-hover-opacity-off w3-center w3-small">
        <a href="#" class="w3-bar-item w3-button" style="width:25% !important">HOME</a>

    </div>
</div>

<!-- Page Content -->
<div class="w3-padding-large" id="main">
    <!-- Header/Home -->
    <header class="w3-container w3-padding-32 w3-center w3-black" id="home">
        <h1 class="w3-jumbo"><span class="w3-hide-small"></span> Application for analyze diseases history</h1>
        <p>For doctors and patients</p>

    </header>

    <!-- About Section -->
    <div class="w3-content w3-justify w3-text-grey w3-padding-64" id="about">
        <h2 class="w3-text-light-grey">This application</h2>
        <hr style="width:200px" class="w3-opacity">
        <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Nullam et turpis ac justo fermentum hendrerit. Phasellus ac turpis nec libero consectetur viverra.
            Aliquam leo lacus, tristique vitae maximus sed, sodales vitae leo. Nunc a magna quis massa dapibus
            dignissim.
            Integer et ultrices sapien. Mauris nec urna mollis, elementum libero vitae, porta turpis. Suspendisse
            fringilla
            nunc id diam imperdiet pretium. Proin justo ante, lacinia id dui ullamcorper, egestas aliquet est.
            Donec ac aliquet arcu. Curabitur et leo in diam faucibus vulputate sit amet sit amet ante. Nunc semper
            lacus nisl, eu pellentesque turpis aliquet sit amet. Pellentesque ac sem sagittis, ornare nisl nec,
            sollicitudin lacus. Nunc eleifend mi nibh, finibus viverra risus elementum ac. Etiam sapien lectus,
            vulputate
            vel mollis ac,
            condimentum eu arcu. Phasellus sit amet egestas dui, vel vestibulum nisl. Nullam ac mauris nunc.</p>


        </button>


        <!-- Testimonials -->
        <h3 class="w3-padding-24 w3-text-light-grey">Idea</h3>

        <p><span class="w3-large w3-margin-right">Magdalena Trędak</span> Biomedical engineering</p>
        <p>Use computers in medicine</p><br>


        <p><span class="w3-large w3-margin-right">Powered by Magdalena Trędak</span></p>
        <p>Use it everywhere anytime</p>
        <!-- End About Section -->
    </div>


    <!-- Footer -->
    <footer class="w3-content w3-padding-64 w3-text-grey w3-xlarge">
        <p><span class="w3-large w3-margin-right">See more on my social media</span></p>
        <a href="https://www.facebook.com/magdalena.tredak"><i class="fa fa-facebook-official w3-hover-opacity"></i></a>
        <a href="https://www.instagram.com/tadgam/"> <i class="fa fa-instagram w3-hover-opacity"></i></a>
        <a href="https://github.com/student236712"><i class="fa fa-github w3-hover-opacity"></i></a>
        <a href="https://www.strava.com/athletes/43953949"><i class="fa fa-bicycle  w3-hover-opacity"></i></a>
        <p class="w3-medium">Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank"
                                           class="w3-hover-text-green">w3.css</a></p>
        <!-- End footer -->
    </footer>

    <!-- END PAGE CONTENT -->
</div>

</body>
</html>
