(ns fuyu_mvp.components.message)

(defn correct []
  [:div "すごい、せいかい！"])

(defn wrong []
  [:div "う〜ん、ちがうみたい。"])

(defn not-answered []
  [:div "□に入るもじはどれかな？"])

(defn selecting []
  [:div "そのまま□へ・・・"])

(defn hovering []
  [:div "指をはなしてみよう！"])

(defn main [selecting? hovering? answered? correct?]
  [:div { :class "message" }
    (if (and answered? correct?)
      (correct)
      (if (and answered? (not correct?))
        (wrong)
        (if (and selecting? hovering?)
          (hovering)
          (if selecting?
            (selecting)
            (not-answered)))))])
