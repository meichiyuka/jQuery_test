'use strict';

$(function() {
  $('.slideLeft').toggleClass('activeL');
  $('.slideRight').toggleClass('activeR');
});

/*$(function() {
  $('.slideRight').toggleClass('activeR');
});*/

const now = new Date();
const year = now.getFullYear();
const month = now.getMonth();
const date = now.getDate();
const hour = now.getHours();
const min = now.getMinutes();
const sec = now.getSeconds();

const output = `${year}/${month + 1}/${date} ${hour}:${min}:${sec}`;
document.getElementById('time').textContent = output;

