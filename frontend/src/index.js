import angular from 'angular';

import 'angular-ui-router';
import routesConfig from './routes';

import main from './app/main';
import header from './app/header/header';
import question from './app/question/question';
import tag from './app/tag/tag';
import questionList from './app/question/question-list';

import './index.scss';

angular
  .module('app', ['ui.router'])
  .config(routesConfig)
  .component('app', main)
  .component('header', header)
  .component('question', question)
  .component('tag', tag)
  .component('questionList', questionList)
  .config($logProvider => {
    $logProvider.debugEnabled(true);
  });
