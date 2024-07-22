<?php
$s = "localhost"; $u = "root"; $p = ""; $db = "a3";
$con = new mysqli($s, $u, $p, $db);
$MaSP = $_GET['MaSP'];
$TenSP = $_GET['TenSP'];
$MoTa = $_GET['MoTa'];
if ($con->connect_error) {
    die("Connection failed: " . $con->connect_error);
}
$sql = "INSERT INTO sanpham1 (MaSP, TenSP, MoTa) VALUES ('$MaSP', '$TenSP', '$MoTa')";
if ($con->query($sql) === TRUE) {
    echo "Insert thành công";
} else {
    echo "Lỗi: " . $con->error;
}
$con->close();
// http://localhost/2024071/insert.php?MaSP=SP001&TenSP=san pham 6&MoTa= Mo ta san pham 6
