(define (move N from to spare)
  (cond ((> N 0)
         (move (-1+ N) from spare to)
         (display (string-append from "->" to "\n"))
         (move (-1+ N) spare to from))))

(move 5 "1" "2" "3")

