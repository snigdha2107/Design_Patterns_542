<?php

$myfile = fopen("input.txt", "w") or die("Unable to open file!");

for($i=0;$i<30;$i++)
{
$Number = substr(str_shuffle("123456789"), 0, rand(8,10));
fwrite($myfile, $Number."\n");
}
fclose($myfile);

?>