<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>upload client list</title>

<script type="text/javascript">
	function namevalid() {
		var n = document.getElementById("files[0]").value;
		if (n == "" || n == null) {
			document.getElementById("namereq").style.visibility = "visible";
			return false;

		}

		else {
			if (n.match(".xml")) {

				document.getElementById("namereq").innerHTML = "";

				document.getElementById("namereq").style.visibility = "hidden";
				return true;
			}

			else {
				document.getElementById("namereq").innerHTML = "Only .xml format are allowed";
				document.getElementById("namereq").style.visibility = "visible";
				return false;

			}
		}
	}

	function formvalid() {

		var nameresult = namevalid();

		if (nameresult == false) {

			return false;
		} else {

			return true;
		}

	}
</script>



</head>
<body>
	<%@ include file="header.jsp"%><br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<p style="color: black; font-family: sans-serif; font-size: x-large;"
		align="center">Client List Upload</p>

	<form:form method="post" action="save.html" modelAttribute="uploadForm"
		onsubmit="return formvalid()" enctype="multipart/form-data">

		<p style="color: black; font-family: sans-serif; font-size: large;"
			align="center">Select XML file to upload.</p>

		<!--  <input id="addFile" type="button" value="Add File" /> -->
		<table style="font-family: sans-serif; font-size: medium;"
			id="fileTable" align="center">
			<tr>
				<td><input onblur="namevalid()" name="files[0]" id="files[0]"
					type="file" /> <samp style="color: #FF0000; visibility: hidden"
						id="namereq">Select some file*</samp></td>
			</tr>

		</table>
		<br />
		<p align="center">
			<input type="submit" value="Upload" />
		</p>
	</form:form>

</body>
</html>