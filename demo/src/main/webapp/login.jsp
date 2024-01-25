<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<title>Hito</title>
<link href="style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="login-page bg-light">
			<div class="container">
			<div class="row">
				<div class="col-lg-10 offset-lg-1">
					<h3 class="mb-3">Registro</h3>
					<div class="bg-white shadow rounded">
						<div class="row">
							<div class="col-md-7 pe-0">
								<div class="form-left h-100 py-5 px-5">
									<form action="Login" method="post" class="row g-4">
										<div class="mb-3">
											<label for="exampleInputEmail1" class="form-label w-100" >Usuario<span class="text-danger">*</span>
												<input type="text" class="form-control"
													placeholder="Escribe tu Usuario" name="username" id="exampleInputEmail1" required>
											</label>
										</div>

										<div class="mb-3">
											<label  for="exampleInputPassword1" class="form-label w-100">Contraseña<span class="text-danger">*</span>

													<input type="password" class="form-control"
														placeholder="Escribe tu contraseña" name="password" id="exampleInputPassword1" required>
											</label>
										</div>

										


										<div class="col-12">
											<button type="submit"
												class="btn btn-primary px-4 float-end mt-4">login</button>
										</div>
									</form>
								</div>
							</div>
							<div class="col-md-5 ps-0 d-none d-md-block">
								<div
									class="form-right h-100 bg-primary text-white text-center pt-5">
									<i class="bi bi-bootstrap"></i>
									<h2 class="fs-1">Aplicacion Notas</h2>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>