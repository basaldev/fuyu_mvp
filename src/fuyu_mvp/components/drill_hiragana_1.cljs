(ns fuyu_mvp.components.drill-hiragana-1
  (:require [fuyu_mvp.components.letter :as letter]))

(defn remove-letter [word-v index]
  (assoc word-v index "　"))

(defn main [word missing]
  (let [words (vec word)]
    [:div {:class "container"} 
      [:div {:class "row"}
        (map letter/main (remove-letter words missing))]
      [:div {:class "row"} (get words missing)]]))
