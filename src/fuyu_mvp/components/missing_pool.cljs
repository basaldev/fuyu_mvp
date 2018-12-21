(ns fuyu_mvp.components.missing-pool)

(defn main [missing-letters]
  [:div {:class "row"}
    (map (fn [letter]
          [:span letter]) missing-letters)])
