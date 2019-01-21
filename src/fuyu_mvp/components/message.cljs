(ns fuyu_mvp.components.message)

(defn correct []
  [:div "すごい、せいかい！"])

(defn wrong []
  [:div "う〜ん、ちがうよ。"])

(defn not-answered []
  [:div "□に入るもじはどれかな？"])

(defn main [answered? result]
  [:div { :class "message" }
    (if answered?
      (if result (correct) (wrong))
      (not-answered))])
