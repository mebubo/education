if (typeof Object.create !== 'function') {
    Object.create = function (o) {
        var F = function () {};
        F.prototype = o;
        return new F();
    };
}

Function.prototype.method = function (name, func) {
    this.prototype[name] = func;
    return this;
};

Array.dim = function (dimension, initial) {
    var a = [], i;
    for (i = 0; i < dimension; i += 1) {
        a[i] = initial;
    }
    return a;
};

Array.method('pushh', function ( ) {
                 this.splice.apply(
                     this,
                     [this.length, 0].concat(Array.prototype.slice.apply(arguments)));
                 return this.length;
             });

var repl = require("repl");
repl.start();
