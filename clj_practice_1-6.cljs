(def myself '("Mark"))
(def myself-with-bros (conj myself "Adam" "Dan" "Mike"))
(def myself-with-sisters (conj myself "Coleen" "Katy"))

(println "me with sisters" myself-with-sisters)
(println "me with bros" myself-with-bros)
(println "just me" myself)

(println)

(def me-map {:me "Mark"})
(def family-map-with-bros (assoc me-map :bro1 "Adam" :bro2 "Dan" :bro3 "Mike"))
(def family-map-with-sisters (assoc me-map :sis1 "Coleen" :sis2 "Katy"))

(println "me-map with sisters" family-map-with-sisters)
(println "me-map with bros" family-map-with-bros)
(println "just me" myself)

(def whole-family (merge family-map-with-bros family-map-with-sisters))
(def whole-family (merge family-map-with-sisters family-map-with-bros))
(def no-m-names (dissoc whole-family :me :bro3))
