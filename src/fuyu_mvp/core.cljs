(ns fuyu_mvp.core
    (:require [goog.dom :as dom]
              [reagent.core :as r]
              [fuyu_mvp.domain.middlewares.init :as init]
              [fuyu_mvp.components.app :as app]))

(enable-console-print!)

(defn mount []
  (r/render [app/main] (dom/getElement "app")))

(init/init-words)
(mount)
