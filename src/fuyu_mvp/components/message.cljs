(ns fuyu_mvp.components.message)

(defn correct []
  [:div "Congraturation!"])

(defn wrong []
  [:div "This is incorrect. Let's try again!"])

(defn not-answered []
  [:div "Let's choose letter"])

(defn main [answered? result]
  [:div { :class "message" }
    (if answered?
      (if result (correct) (wrong))
      (not-answered))])
