<?php
$res=array();
$s = "localhost"; $u = "root"; $p = ""; $db = "a3";
$con = new mysqli($s, $u, $p, $db);
$MaSP = $_POST['MaSP'];
$TenSP = $_POST['TenSP'];
$MoTa = $_POST['MoTa'];
if ($con->connect_error) {
    die("Connection failed: " . $con->connect_error);
}
$sql = "INSERT INTO sanpham1 (MaSP, TenSP, MoTa) VALUES ('$MaSP', '$TenSP', '$MoTa')";
if ($con->query($sql) === TRUE) {
    $res['success']=1;
    $res['message']= "Insert thành công";
    echo json_encode($res);
} else {
    $res['success']=0;
    $res['message']= "Insert kh thành công";
    echo json_encode($res);
}
$con->close();
// http://localhost/2024071/insert1.php?MaSP=SP04&TenSP=san pham 5&MoTa= Mo ta san pham 4
