(defn create-triangle [leg]
    (let [verified-leg (if (> leg 1) leg 2)]
        {:leg verified-leg}))

(defn get-leg [triangle]
    (triangle :leg))

(defn square [length]
  (* length length))

(defn get-area [triangle]
    (/ (* (square (get-leg triangle))) 2))

(defn get-perimeter [triangle]
    (Math/sqrt (+ (* 2 (square (get-leg triangle))))))

(defn draw-triangle [triangle]
  (let [leg (get-leg triangle)
        top-bottom-row-seq (repeat leg "*")
        top-bottom-row-text (apply str top-bottom-row-seq)
        all-middle-rows (for [i (range 1 (- leg 1))]
                          (str "*" (apply str (repeat i " ")) "*"))]
    (println "*")
    (doseq [row all-middle-rows]
      (println row))
    (println top-bottom-row-text)))

(defn print-triangle [triangle]
    (println "Leg" (get-leg triangle))
    (println "Area" (get-area triangle))
    (println "Perimeter" (get-perimeter triangle))
    (draw-triangle triangle))

(defn expand [triangle scaling-factor]
    (create-triangle (* (get-leg triangle) scaling-factor)))

(def triangle1 (create-triangle 4))
(print-triangle triangle1)

;; (defn draw-triangle [triangle]
;;     (let [top-bottom-row-seq (repeat (get-width triangle) "*")
;;           top-bottom-row-text (apply str top-bottom-row-seq)
;;           middle-row-space-seq (repeat (- (get-width triangle) 2) " ")
;;           ;; middle-row-space-seq (repeat (- (+ (Math/ceil (/ (get-width triangle) 2)) 1)) " ")
;;           middle-row-space-text (apply str middle-row-space-seq)
;;           middle-row-text (str "*" middle-row-space-text "*")
;;           all-middle-rows (repeat (- (get-leg triangle) 2) middle-row-text)]
;;         (println "*")
;;         (doseq [row all-middle-rows]
;;             (println row))
;;         (println top-bottom-row-text)))

;; (def triangle2 (expand triangle1 7))
;; (print-triangle triangle2)
