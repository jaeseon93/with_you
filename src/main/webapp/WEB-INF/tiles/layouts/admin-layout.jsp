<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>



<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="description"
	content="Creative - Bootstrap 3 Responsive Admin Template">

<meta name="author" content="GeeksLabs">

<meta name="keyword"
	content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">

<link rel="shortcut icon" href="img/favicon.png">



<title>Grids | Creative - Bootstrap 3 Responsive Admin Template</title>



<!-- Bootstrap CSS -->

<link href="resources/admin/css/bootstrap.min.css" rel="stylesheet">

<!-- bootstrap theme -->

<link href="resources/admin/css/bootstrap-theme.css" rel="stylesheet">

<!--external css-->

<!-- font icon -->

<link href="resources/admin/css/elegant-icons-style.css"
	rel="stylesheet" />

<link href="resources/admin/css/font-awesome.min.css" rel="stylesheet" />

<!-- Custom styles -->

<link href="resources/admin/css/style.css" rel="stylesheet">

<link href="resources/admin/css/style-responsive.css" rel="stylesheet" />



<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->

<!--[if lt IE 9]>

      <script src="js/html5shiv.js"></script>

      <script src="js/respond.min.js"></script>

      <script src="js/lte-ie7.js"></script>

    <![endif]-->



<!-- =======================================================

      Theme Name: NiceAdmin

      Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/

      Author: BootstrapMade

      Author URL: https://bootstrapmade.com

    ======================================================= -->



<!-- javascripts -->

<script src="resources/admin/js/jquery.js"></script>

<script src="resources/admin/js/bootstrap.min.js"></script>

<!-- nice scroll -->

<script src="resources/admin/js/jquery.scrollTo.min.js"></script>

<script src="resources/admin/js/jquery.nicescroll.js"
	type="text/javascript"></script>



<!--custome script for all page-->

<script src="resources/admin/js/scripts.js"></script>





</head>





<body>

	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="aside" />



	<section id="main-content">

		<section class="wrapper">

			<tiles:insertAttribute name="content" />

		</section>

	</section>



	<!--main content end-->

	<div class="text-right">

		<div class="credits">

			<!--

            All the links in the footer should remain intact.

            You can delete the links only if you purchased the pro version.

            Licensing information: https://bootstrapmade.com/license/

            Purchase the pro version form: https://bootstrapmade.com/buy/?theme=NiceAdmin

          -->

			Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>

		</div>

	</div>

	<!-- container section end -->



</body>

</html>