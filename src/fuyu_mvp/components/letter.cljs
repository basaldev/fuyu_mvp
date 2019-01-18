(ns fuyu_mvp.components.letter)

(let [style {"border" "1px solid"}]
  (defn main [letter column]
    [:div {:class (str "col-sm-" column) :style style :key letter} letter]))
