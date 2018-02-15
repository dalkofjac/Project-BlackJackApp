<?php
  //if "email" variable is filled out, send email
  if (isset($_POST['email']))  {
      
  $admin_email = "mymail@mydomain.com";
  $name = $_POST['name'];
  $email = $_POST['email'];
  $message = $_POST['message'];
  
  //Security
  $name = stripslashes($name);
  $email = stripslashes($email);
  $message = stripslashes($message);
  
  //send email
  mail($admin_email, "BlackJack - User comment", $name . "\n" . $email . "\n" . $message);
  echo "done";
  }
  //if "email" is missing, return error
  else{
      echo "error";
  }
?>