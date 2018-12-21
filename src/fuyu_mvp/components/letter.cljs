(ns fuyu_mvp.components.letter)

(let [style {"border" "1px solid"}]
  (defn main [letter]
    [:div {:class "col-sm-3" :style style} letter]))

