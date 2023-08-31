(type (vec '(:a :b :c)))
(type (list :a :b :c))
(type [:a :b :c])
(require 'clojure.set)
(clojure.set/union #{:a :b :c} #{:b :c :d})

;; set vs. vector vs. list
;; sequence vs. map

;; vector: ["b" "c"]

(= #{1 2 3 4} (conj #{1 4 3} 2))
(conj #{1 4 3} 2)

(hash-map :a 10, :b 20, :c 30)
((hash-map :a 10, :b 20, :c 30) :b)

(first '(3 2 1))
(second [2 3 4])
(last (list 1 2 3))

;; Problem 14, Functions

(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

(= 4 ((fn double [x] (* x 2)) 2))
(partial * 2) ;; wow

;; Problem 16, Hello World

(fn greeting [x] (str "Hello, " x "!"))
(fn [name] (str "Hello, " name "!"))

;; Problem 17, map

;; Problem 19, Last Element
(fn last-element [x] (first (reverse x)))

(fn second-to-last-element [x] (first (take-last 2 x)))
