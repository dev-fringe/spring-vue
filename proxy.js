const Bundler = require('parcel-bundler');
const express = require('express');
const proxy = require('http-proxy-middleware');

const app = express();

app.use('/api', proxy({
  target: 'http://localhost:8080/api'
}));

const bundler = new Bundler('src/main/javascript/index.html');
app.use(bundler.middleware());


app.listen('1234', function () {
  console.log('running on 1234 and proxied to 8080')
});