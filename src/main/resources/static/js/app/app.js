'use strict'

var demoApp = angular.module('demo', [ 'ui.bootstrap', 'demo.controllers',
		'demo.services' ]);
demoApp.constant("CONSTANTS", {
	getUserByIdUrl : "/user/getUser/",
	getAllUsers : "/findall",
	saveUser : "/addEmployee",
    editEmployee: "/employee/",
    getEmployeeList: "/findall",
    deleteEmployee: "/employee/",
    getEmployee: "/employee/"
});