;; 6.3
(defun display-first-60-chars-of-current-buffer ()
  (interactive)
  (save-restriction
    (widen)
    (message (buffer-substring-no-properties 1 60)))
)

;; 7.7
(setq fr (cons 'finch (cons 'raven ())))
(setq birds (cons 'ostrich fr))
(setq birds (cons 'robin birds))
;;(cons birds birds)
(setcar birds 'shark)
birds
(setcdr birds '(perch rutilus esox))
birds

