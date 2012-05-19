function memoize(memo, formula) {
    return function ret(n) {
        var val = memo[n];
        if (typeof val === 'undefined') {
            val = formula(ret, n);
            memo[n] = val;
            console.log(memo);
        }
        return val;
    };
}

var fibonacci = memoize({0:0, 1:1}, function(f, n) {return f(n-1) + f(n-2);});
var factorial = memoize({0:0, 1:1}, function(f, n) {return f(n-1) * n;});

console.log(fibonacci(10));
console.log(factorial(10));
