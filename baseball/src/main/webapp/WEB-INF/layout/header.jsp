<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>야구장 페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

<div class="container">

<table class="table table-bordered">

<table class="table table">
      <tr>
        <th><a href ="/stadiumForm">야구장 등록</a></th>
        <th><a href ="/teamForm">팀 등록</a></th>
        <th><a href ="/playerForm">선수 등록</a></th>
        <th><a href ="#">퇴출선수 등록</a></th>
        <th><a href ="/stadium">야구장 관리</a></th>
        <th><a href ="/team">팀 관리</a></th>
        <th><a href ="/player">선수 관리</a></th>
        <th><a href ="/player/position">포지션별 선수</a></th>
        <th><a href ="#">팀별 선수</a></th>
      </tr>
      </table>