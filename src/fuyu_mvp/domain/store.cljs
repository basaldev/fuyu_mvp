(ns fuyu_mvp.domain.store)

(def state
  (atom { :question "こうえん"
          :options "あかさたな"
          :missing 2
          :selecting? false
          :correct? false}))

(def subscribers
  (vec []))

(defn subscribe [subscriber]
  (conj subscribers subscriber))

(defn emit []
  (map (fn [subscriber] (subscribe state)) subscribers))

(defn swap [key value]
  (swap! state assoc key value)
  (println "update state: " key value @state)
  (emit))
