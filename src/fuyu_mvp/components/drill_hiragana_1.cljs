(ns fuyu_mvp.components.drill-hiragana-1
  (:require [fuyu_mvp.components.letter :as letter]))

(defn remove-letter [word-v index]
  (assoc word-v index "　"))

(defn main [word missing]
  [:div {:class "container"} 
    (map letter/main (remove-letter (vec word) missing))])
