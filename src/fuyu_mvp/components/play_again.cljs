(ns fuyu_mvp.components.play-again
  (:require [fuyu_mvp.domain.middlewares.user :as user]))

(defn main []
  [ :button
    {:on-click (fn [] (user/play-again))}
    "もういっかいやる！"])
