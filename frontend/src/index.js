import angular from 'angular';

import {techsModule} from './app/techs/index';
import 'angular-ui-router';
import 'angular-ui-bootstrap';
import routesConfig from './routes';

import {main} from './app/main';
import {header} from './app/header/header';
import {question} from './app/question/question';
// import {nwbolt} from './bolt-bootstrap';

import './index.scss';
import './bolt-bootstrap-lite.css';

angular
  .module('app', [techsModule, 'ui.router', 'ui.bootstrap'])
  .config(routesConfig)
  .component('app', main)
  .component('header', header)
  .component('question', question);
