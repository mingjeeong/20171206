<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-grid.css">
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-reboot.css">
	<script src="resources/js/jquery-3.2.1.js"></script>
	<script src="https://unpkg.com/popper.js"></script>
	<script src="https://unpkg.com/tooltip.js"></script>
	<script src="resources/js/bootstrap.bundle.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<button class="btn btn-primary">테스트!</button>
<button class="btn btn-danger">테스트!</button>
<button class="btn btn-link">테스트!</button>
<button class="btn btn-info">테스트!</button>
<button class="btn btn-success">테스트!</button>
<button class="btn btn-secondary">테스트!</button>
<button class="btn btn-warning">테스트!</button>
<!-- table -->
<h3> Table </h3>
<table class="table table-striped table-hover table-bordered">
	<thead class="thead-dark">
		<tr>
			<th>no</th>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
		</tr>
	</thead>
	<tbody>
		<tr class="danger">
			<td>1</td>
			<td>이동훈</td>
			<td>19</td>
			<td>남</td>
		</tr>
		<tr>
			<td>2</td>
			<td>김재림</td>
			<td>19</td>
			<td>남</td>
		</tr>
		<tr>
			<td>3</td>
			<td>이원호</td>
			<td>19</td>
			<td>남</td>
		</tr>
		<tr>
			<td>4</td>
			<td>이민정</td>
			<td>19</td>
			<td>녀자</td>
		</tr>
	</tbody>
</table>
<!-- input -->
<h3> Input </h3>
<input type="email" class="form-control">
<input type="email" class="form-control is-valid">
<input type="email" class="form-control is-invalid">

<!-- tab -->
<h3> Tab </h3>
<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" data-toggle="tab" href="#home">Home</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#profile">Profile</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#">Disabled</a>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Action</a>
      <a class="dropdown-item" href="#">Another action</a>
      <a class="dropdown-item" href="#">Something else here</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="#">Separated link</a>
    </div>
  </li>
</ul>
<div id="myTabContent" class="tab-content">
  <div class="tab-pane fade active in" id="home">
    <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
  </div>
  <div class="tab-pane fade" id="profile">
    <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit.</p>
  </div>
  <div class="tab-pane fade" id="dropdown1">
    <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork.</p>
  </div>
  <div class="tab-pane fade" id="dropdown2">
    <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater.</p>
  </div>
</div>

<!-- Popovers -->
<h3> Popovers </h3>
<button type="button" class="btn btn-secondary" title="" data-container="body" data-toggle="popover" data-placement="left" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." data-original-title="Popover Title">Left</button>

<button type="button" class="btn btn-secondary" title="" data-container="body" data-toggle="popover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." data-original-title="Popover Title">Top</button>

<button type="button" class="btn btn-secondary" title="" data-container="body" data-toggle="popover" data-placement="bottom" data-content="Vivamus
sagittis lacus vel augue laoreet rutrum faucibus." data-original-title="Popover Title">Bottom</button>

<button type="button" class="btn btn-secondary" title="" data-container="body" data-toggle="popover" data-placement="right" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." data-original-title="Popover Title">Right</button>

<!-- Tooltips -->
<h3> Tooltips </h3>
<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="left" title="" data-original-title="Tooltip on left">Left</button>

<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Tooltip on top">Top</button>

<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Tooltip on bottom">Bottom</button>

<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="right" title="" data-original-title="Tooltip on right">Right</button>

<!-- Card -->
<h3> Card </h3>
<div class="card text-white bg-primary">
  <div class="card-body">
    <blockquote class="card-blockquote">
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
      <footer>Someone famous in <cite title="Source Title">Source Title</cite></footer>
    </blockquote>
  </div>
</div>
  
<!-- ListGroup -->
<p>
<h3> ListGroup </h3>
<div class="list-group">
  <a href="#" class="list-group-item  list-group-item-action active">
    Cras justo odio
  </a>
  <a href="#" class="list-group-item list-group-item-action">Dapibus ac facilisis in
  </a>
  <a href="#" class="list-group-item list-group-item-action disabled">Morbi leo risus
  </a>
</div>

<!-- Jumbotron -->
<h3> Jumbotron </h3>
<div class="jumbotron">
  <h1 class="display-3">된당</h1>
  <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
  <p><a class="btn btn-primary btn-lg" href="#">Learn more</a></p>
</div>

<!-- Progress -->
<h3> Progress </h3>
<div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 40%"></div>
</div>

<!-- Alert -->
<h3> Alert </h3>
<div class="alert alert-dismissible alert-warning">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  <h4>Warning!</h4>
  <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
</div>

<!-- Badge -->
<h3> Badges </h3>
<span class="badge badge-pill badge-success">Success</span>

<!-- BreadCrumbs -->
<h3> BreadCrumbs </h3>
<ol class="breadcrumb">
  <li class="breadcrumb-item active">Home</li>
</ol>
<ol class="breadcrumb">
  <li class="breadcrumb-item"><a href="#">Home</a></li>
  <li class="breadcrumb-item active">Library</li>
</ol>
<ol class="breadcrumb">
  <li class="breadcrumb-item"><a href="#">Home</a></li>
  <li class="breadcrumb-item"><a href="#">Library</a></li>
  <li class="breadcrumb-item active">Data</li>
</ol>

<!-- Page -->
<h3> Page </h3>
<div>
  <ul class="pagination">
    <li class="page-item disabled">
      <a class="page-link" href="#">&laquo;</a>
    </li>
    <li class="page-item active">
      <a class="page-link" href="#">1</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">2</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">3</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">4</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">5</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">&raquo;</a>
    </li>
  </ul>
</div>

<!-- Pills -->
<h3> Pills </h3>
<ul class="nav nav-pills">
  <li class="nav-item">
    <a class="nav-link active" href="#">Active</a>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Action</a>
      <a class="dropdown-item" href="#">Another action</a>
      <a class="dropdown-item" href="#">Something else here</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="#">Separated link</a>
    </div>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Link</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#">Disabled</a>
  </li>
</ul>

<!-- Modals -->
<h3> Modals </h3>
<div class="modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<button type="button" class="btn btn-secondary" data-container="body" data-toggle="popover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
  Popover on top
</button>

</body>
</html>
