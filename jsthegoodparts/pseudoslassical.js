require("./core.js");

var p = console.log;

// new implemented as a method
Function.method('new', function ( ) {
                    // Create a new object that inherits from the
                    // constructor's prototype.
                    var that = Object.create(this.prototype);
                    // Invoke the constructor, binding –this- to
                    // the new object.
                    var other = this.apply(that, arguments);
                    // If its return value isn't an object,
                    // substitute the new object.
                    return (typeof other === 'object' && other) || that;
                });

var Mammal = function (name) {
    this.name = name;
};

Mammal.prototype.get_name = function ( ) {
    return this.name;
};

Mammal.prototype.says = function ( ) {
    return this.saying || '';
};

var myMammal = new Mammal('Herb the Mammal');
var name = myMammal.get_name( ); // 'Herb the Mammal'

p(name);

var Cat = function (name) {
    this.name = name;
    this.saying = 'meow';
};

// Replace Cat.prototype with a new instance of Mammal
Cat.prototype = new Mammal( );

// Augment the new prototype with
// purr and get_name methods.
Cat.prototype.purr = function (n) {
    var i, s = '';
    for (i = 0; i < n; i += 1) {
        if (s) {
            s += '-';
        }
        s += 'r';
    }
    return s;
};

Cat.prototype.get_name = function ( ) {
    return this.says( ) + ' ' + this.name + ' ' + this.says( );
};

var myCat = new Cat('Henrietta');
var says = myCat.says( ); // 'meow'
var purr = myCat.purr(5); // 'r-r-r-r-r'
var name = myCat.get_name( ); // 'meow Henrietta meow'

p(says);
p(purr);
p(name);
