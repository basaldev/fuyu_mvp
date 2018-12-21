(ns fuyu_mvp.components.drill-hiragana-1
  (:require [fuyu_mvp.components.letter :as letter]))

(defn main [word]
  [:div {:class "container"} 
    (map letter/main (vec word))])
